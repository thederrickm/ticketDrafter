package com.ticketdrafter.model;

import java.util.HashMap;
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
        "visitor",
        "ticket_0",
        "ticket_1",
        "ticket_2"
})
@Generated("jsonschema2pojo")
public class Game {

    @JsonProperty("date")
    private String date;
    @JsonProperty("visitor")
    private String visitor;
    @JsonProperty("ticket_0")
    private String ticket0;
    @JsonProperty("ticket_1")
    private String ticket1;
    @JsonProperty("ticket_2")
    private String ticket2;
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

    @JsonProperty("ticket_0")
    public String getTicket0() {
        return ticket0;
    }

    @JsonProperty("ticket_0")
    public void setTicket0(String ticket0) {
        this.ticket0 = ticket0;
    }

    @JsonProperty("ticket_1")
    public String getTicket1() {
        return ticket1;
    }

    @JsonProperty("ticket_1")
    public void setTicket1(String ticket1) {
        this.ticket1 = ticket1;
    }

    @JsonProperty("ticket_2")
    public String getTicket2() {
        return ticket2;
    }

    @JsonProperty("ticket_2")
    public void setTicket2(String ticket2) {
        this.ticket2 = ticket2;
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
