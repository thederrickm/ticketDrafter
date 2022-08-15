package com.ticketdrafter.schedule.nhl;

import java.util.HashMap;
import java.util.LinkedHashMap;
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
        "date",
        "visitor",git a
        "draftTickets"
})
@Generated("jsonschema2pojo")
public class DraftSchedule {

    @JsonProperty("date")
    private String date;
    @JsonProperty("visitor")
    private String visitor;
    @JsonProperty("draftTickets")
    private LinkedHashMap<String, String> draftTickets;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("date")
    public String getDate() {
        return date;
    }

    @JsonProperty("date")
    public void setDate(String date) {
        this.date = date;
    }

    @JsonProperty("visitor")
    public String getVisitor() {
        return visitor;
    }

    @JsonProperty("visitor")
    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    @JsonProperty("draftTickets")
    public LinkedHashMap<String, String> getDraftTickets() {
        return draftTickets;
    }

    @JsonProperty("draftTickets")
    public void setDraftTickets(LinkedHashMap<String, String> draftTickets) {
        this.draftTickets = draftTickets;
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