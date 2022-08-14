package com.ticketdrafter.controller;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ticketdrafter.model.ScheduleModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/draft")
public class DraftController {


    @PostMapping("/new")
    @ResponseBody
    public Map<String, Object> createDraftSchedule(@RequestParam int team, String owner, String league, int tickets) throws IOException {

        String nhlScheduleAPI = "https://statsapi.web.nhl.com/api/v1/schedule?gameType=R&teamId=";
        String nhlScheduleRange = "&season=20222023";
        String teamScheduleURL = nhlScheduleAPI + team + nhlScheduleRange;

        ResponseEntity<String> data = new RestTemplate().getForEntity(teamScheduleURL, String.class);
        JsonFactory jsonFactory = new JsonFactory();
        JsonNode datesArray = new ObjectMapper(jsonFactory).readTree(data.getBody()).get("dates");

        List<LinkedHashMap<String, String>> gameSchedule = new ArrayList<>();

        if (datesArray.isArray()) {
            for (JsonNode dateNode : datesArray) {
                JsonNode gamesArray = dateNode.get("games");
                if (gamesArray.isArray()) {
                    for (JsonNode gameNode : gamesArray) {
                        int homeId = gameNode.at("/teams/home/team/id").asInt();
                        if (homeId == team) {
                            LinkedHashMap<String, String> gameDetails = new LinkedHashMap<>();
                            String gameDate = gameNode.get("gameDate").asText();
                            String visitingTeam = gameNode.at("/teams/away/team/name").asText();

                            gameDetails.put("date", gameDate);
                            gameDetails.put("visitor", visitingTeam);
                            for (int i=0; i < tickets; i++ ) {
                                String ticketGroup = "ticket_" + i;
                                gameDetails.put(ticketGroup, "");
                            }
                            gameSchedule.add(gameDetails);

                            }
                        }
                    }
                }
            }

        Map<String, Object> draftRecordMap = new LinkedHashMap<>();

        draftRecordMap.put("ownerEmail", owner);
        draftRecordMap.put("homeTeam", String.valueOf(team));
        draftRecordMap.put("ticketGroups", String.valueOf(tickets));
        draftRecordMap.put("draftCreated", new java.util.Date().toString());
        draftRecordMap.put("games", gameSchedule);

        return draftRecordMap;
    }
}

