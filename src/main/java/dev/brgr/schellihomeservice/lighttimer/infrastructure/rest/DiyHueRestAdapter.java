package dev.brgr.schellihomeservice.lighttimer.infrastructure.rest;

import dev.brgr.schellihomeservice.lighttimer.core.ports.out.ControlLight;
import dev.brgr.schellihomeservice.lighttimer.infrastructure.dto.request.StateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DiyHueRestAdapter implements ControlLight {
    private final DiyHueClient diyHueClient;

    @Override
    public void switchLight(boolean on, String bridgeId, int lightId) {
        diyHueClient.changeLightState(new StateRequest(on), bridgeId,lightId);
    }
}
