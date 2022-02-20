package dev.brgr.schellihomeservice.lighttimer.core.model;


import lombok.AllArgsConstructor;
import lombok.Value;

import java.util.List;

@Value
@AllArgsConstructor
public class TimerResponse {
    private List<Timer> timers;
}
