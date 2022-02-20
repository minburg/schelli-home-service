package dev.brgr.schellihomeservice.growtimer.core.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import java.time.LocalTime;

@Value
@AllArgsConstructor
public class Timer {
    private Long timerId;
    private LightId lightId;
    private BridgeId bridgeId;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean active;
}
