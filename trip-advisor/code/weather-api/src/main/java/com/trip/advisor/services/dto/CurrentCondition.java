package com.trip.advisor.services.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CurrentCondition {

    @JsonProperty("temp_F")
    private String temperature;

    public CurrentCondition() {
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
}
