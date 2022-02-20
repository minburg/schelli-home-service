package dev.brgr.schellihomeservice.lighttimer.infrastructure.dto.request;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
public class StateRequest {
    private boolean on;
}
