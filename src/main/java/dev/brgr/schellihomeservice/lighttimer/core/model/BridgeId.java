package dev.brgr.schellihomeservice.lighttimer.core.model;

import lombok.Value;

@Value
public class BridgeId {
    private String value;

    public BridgeId(String value) {
        if(value == null || value.isEmpty() || value.isBlank()){
            throw new IllegalArgumentException("Value of BridgeId cannot be empty!");
        }
        this.value = value;
    }
}
