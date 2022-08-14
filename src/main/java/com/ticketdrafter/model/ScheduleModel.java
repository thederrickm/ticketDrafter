package com.ticketdrafter.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "ownerEmail",
        "homeTeam",
        "ticketGroups",
        "draftCreated",
        "games"
})
@Generated("jsonschema2pojo")
public class ScheduleModel {

    @JsonProperty("ownerEmail")
    private Object ownerEmail;
    @JsonProperty("homeTeam")
    private String homeTeam;
    @JsonProperty("ticketGroups")
    private String ticketGroups;
    @JsonProperty("draftCreated")
    private String draftCreated;
    @JsonProperty("games")
    private List<Game> games = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("ownerEmail")
    public Object getOwnerEmail() {
        return ownerEmail;
    }

    @JsonProperty("ownerEmail")
    public void setOwnerEmail(Object ownerEmail) {
        this.ownerEmail = ownerEmail;
    }

    @JsonProperty("homeTeam")
    public String getHomeTeam() {
        return homeTeam;
    }

    @JsonProperty("homeTeam")
    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    @JsonProperty("ticketGroups")
    public String getTicketGroups() {
        return ticketGroups;
    }

    @JsonProperty("ticketGroups")
    public void setTicketGroups(String ticketGroups) {
        this.ticketGroups = ticketGroups;
    }

    @JsonProperty("draftCreated")
    public String getDraftCreated() {
        return draftCreated;
    }

    @JsonProperty("draftCreated")
    public void setDraftCreated(String draftCreated) {
        this.draftCreated = draftCreated;
    }

    @JsonProperty("games")
    public List<Game> getGames() {
        return games;
    }

    @JsonProperty("games")
    public void setGames(List<Game> games) {
        this.games = games;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}