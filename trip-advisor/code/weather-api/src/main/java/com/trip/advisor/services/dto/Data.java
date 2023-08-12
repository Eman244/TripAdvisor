package com.trip.advisor.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Data {

    @JsonProperty("current_condition")
    private List<CurrentCondition> conditions;

    public Data() {
    }

    public List<CurrentCondition> getConditions() {
        return conditions;
    }

    public void setConditions(List<CurrentCondition> conditions) {
        this.conditions = conditions;
    }
}
