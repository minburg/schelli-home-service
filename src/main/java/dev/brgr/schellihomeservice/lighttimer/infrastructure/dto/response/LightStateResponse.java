package dev.brgr.schellihomeservice.lighttimer.infrastructure.dto.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LightStateResponse {
    private State state;
}
