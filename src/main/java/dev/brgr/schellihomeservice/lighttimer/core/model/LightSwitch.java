package dev.brgr.schellihomeservice.lighttimer.core.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class LightSwitch {
    private String bridgeId;
    private int lightId;
    private boolean activate;
}
