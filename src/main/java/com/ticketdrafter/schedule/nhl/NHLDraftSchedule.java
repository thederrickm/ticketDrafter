package com.ticketdrafter.schedule.nhl;

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
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "draftOwner",
        "draftTeam",
        "draftTickets",
        "draftCreated",
        "draftStatus",
        "draftMembers",
        "draftSchedule"
})
@Document(collection = "drafts")
@Generated("jsonschema2pojo")
public class NHLDraftSchedule {

    @Id
    private String id;

    @JsonProperty("draftOwner")
    private String draftOwner;
    @JsonProperty("draftTeam")
    private String draftTeam;
    @JsonProperty("draftTickets")
    private String draftTickets;
    @JsonProperty("draftCreated")
    private String draftCreated;
    @JsonProperty("draftStatus")
    private String draftStatus;
    @JsonProperty("draftMembers")
    private List<String> draftMembers = null;
    @JsonProperty("draftSchedule")
    private List<DraftSchedule> draftSchedule = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("draftOwner")
    public String getDraftOwner() {
        return draftOwner;
    }

    @JsonProperty("draftOwner")
    public void setDraftOwner(String draftOwner) {
        this.draftOwner = draftOwner;
    }

    @JsonProperty("draftTeam")
    public String getDraftTeam() {
        return draftTeam;
    }

    @JsonProperty("draftTeam")
    public void setDraftTeam(String draftTeam) {
        this.draftTeam = draftTeam;
    }

    @JsonProperty("draftTickets")
    public String getDraftTickets() {
        return draftTickets;
    }

    @JsonProperty("draftTickets")
    public void setDraftTickets(String draftTickets) {
        this.draftTickets = draftTickets;
    }

    @JsonProperty("draftCreated")
    public String getDraftCreated() {
        return draftCreated;
    }

    @JsonProperty("draftCreated")
    public void setDraftCreated(String draftCreated) {
        this.draftCreated = draftCreated;
    }

    @JsonProperty("draftStatus")
    public String getDraftStatus() {
        return draftStatus;
    }

    @JsonProperty("draftStatus")
    public void setDraftStatus(String draftStatus) {
        this.draftStatus = draftStatus;
    }

    @JsonProperty("draftMembers")
    public List<String> getDraftMembers() {
        return draftMembers;
    }

    @JsonProperty("draftMembers")
    public void setDraftMembers(List<String> draftMembers) {
        this.draftMembers = draftMembers;
    }

    @JsonProperty("draftSchedule")
    public List<DraftSchedule> getDraftSchedule() {
        return draftSchedule;
    }

    @JsonProperty("draftSchedule")
    public void setDraftSchedule(List<DraftSchedule> draftSchedule) {
        this.draftSchedule = draftSchedule;
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