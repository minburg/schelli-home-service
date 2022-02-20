package dev.brgr.schellihomeservice.lighttimer.application.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class TimerDto {
    private long timerId;
    private int lightId;
    private String bridgeId;
    private LocalTime startTime;
    private LocalTime endTime;
    private boolean active;
}
