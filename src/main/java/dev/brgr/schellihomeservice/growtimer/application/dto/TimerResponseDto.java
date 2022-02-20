package dev.brgr.schellihomeservice.growtimer.application.dto;

import lombok.Data;

import java.util.List;

@Data
public class TimerResponseDto {
    private List<TimerDto> timers;
}
