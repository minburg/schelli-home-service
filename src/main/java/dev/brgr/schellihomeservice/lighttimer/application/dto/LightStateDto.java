package dev.brgr.schellihomeservice.lighttimer.application.dto;

import lombok.Data;

import java.time.LocalTime;

@Data
public class LightStateDto {
    private boolean active;
}
