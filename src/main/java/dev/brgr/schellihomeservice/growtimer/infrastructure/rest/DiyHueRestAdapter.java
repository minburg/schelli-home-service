package dev.brgr.schellihomeservice.growtimer.infrastructure.rest;

import dev.brgr.schellihomeservice.growtimer.core.ports.out.ControlGrowLight;
import dev.brgr.schellihomeservice.growtimer.infrastructure.dto.request.StateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DiyHueRestAdapter implements ControlGrowLight {
    private final DiyHueClient diyHueClient;

    @Override
    public void switchGrowLight(boolean on, String bridgeId, int lightId) {
        diyHueClient.changeLightState(new StateRequest(on), bridgeId,lightId);
    }
}
