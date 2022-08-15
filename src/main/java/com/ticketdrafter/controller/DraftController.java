package com.ticketdrafter.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketdrafter.schedule.nhl.NHLDraftSchedule;
import com.ticketdrafter.schedule.nhl.ScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.*;



@RestController
@RequestMapping("/api/draft")
public class DraftController {

    @Autowired
    ScheduleRepository scheduleRepository;

    @GetMapping("/active")
    public String getActiveDrafts() {
        Query query = new Query();
        query.addCriteria(Criteria.where("draftStatus").is("active"));

        return "test";
    }

    @PostMapping("/new")
    @ResponseBody
    public NHLDraftSchedule createDraftSchedule(@RequestParam int team, String owner, String league, int tickets) throws IOException {

        String nhlScheduleAPI = "https://statsapi.web.nhl.com/api/v1/schedule?gameType=R&teamId=";
        String nhlScheduleRange = "&season=20222023";
        String teamScheduleURL = nhlScheduleAPI + team + nhlScheduleRange;

        ResponseEntity<String> data = new RestTemplate().getForEntity(teamScheduleURL, String.class);
        JsonFactory jsonFactory = new JsonFactory();
        JsonNode datesArray = new ObjectMapper(jsonFactory).readTree(data.getBody()).get("dates");

        List<LinkedHashMap<String, Object>> gameSchedule = new ArrayList<>();

        if (datesArray.isArray()) {
            for (JsonNode dateNode : datesArray) {
                JsonNode gamesArray = dateNode.get("games");
                if (gamesArray.isArray()) {
                    for (JsonNode gameNode : gamesArray) {
                        int homeId = gameNode.at("/teams/home/team/id").asInt();
                        if (homeId == team) {
                            LinkedHashMap<String, Object> gameDetails = new LinkedHashMap<>();
                            String gameDate = gameNode.get("gameDate").asText();
                            String visitingTeam = gameNode.at("/teams/away/team/name").asText();

                            gameDetails.put("date", gameDate);
                            gameDetails.put("visitor", visitingTeam);
                            LinkedHashMap<String, String> ticketHash = new LinkedHashMap<>();

                            for (int i=0; i < tickets; i++ ) {
                                String ticketGroup = "ticket_" + i;
                                ticketHash.put(ticketGroup, "");
                                // gameDetails.put(ticketGroup, "");
                            }
                            gameDetails.put("draftTickets", ticketHash);
                            gameSchedule.add(gameDetails);

                            }
                        }
                    }
                }
            }

        Map<String, Object> draftRecordMap = new LinkedHashMap<>();

        // temp
        List<String> members = new LinkedList<>();
        members.add("me");
        members.add("them");
        members.add("they");

        draftRecordMap.put("draftOwner", owner);
        draftRecordMap.put("draftTeam", String.valueOf(team));
        draftRecordMap.put("draftTickets", String.valueOf(tickets));
        draftRecordMap.put("draftCreated", new java.util.Date().toString());
        draftRecordMap.put("draftStatus", "Active");
        draftRecordMap.put("draftMembers", members);
        draftRecordMap.put("draftSchedule", gameSchedule);



        ObjectMapper objectMapper = new ObjectMapper();
        NHLDraftSchedule nhlDraftSchedule = objectMapper.convertValue(draftRecordMap, NHLDraftSchedule.class);


        scheduleRepository.save(nhlDraftSchedule);
        return nhlDraftSchedule;
    }
}

