package dev.brgr.schellihomeservice.lighttimer.core.model;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class LightState {
    private boolean active;
}
