package dev.brgr.schellihomeservice.lighttimer.application.dto;

import lombok.Data;

@Data
public class LightSwitchDto {
    private String bridgeId;
    private int lightId;
    private boolean activate;
}
