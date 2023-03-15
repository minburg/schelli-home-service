package dev.brgr.schellihomeservice.lighttimer.infrastructure.rest;

import dev.brgr.schellihomeservice.lighttimer.core.model.LightState;
import dev.brgr.schellihomeservice.lighttimer.core.ports.out.ManageLight;
import dev.brgr.schellihomeservice.lighttimer.infrastructure.dto.mapper.LightStateMapperInfra;
import dev.brgr.schellihomeservice.lighttimer.infrastructure.dto.request.StateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class DiyHueRestAdapter implements ManageLight {
    private final DiyHueClient diyHueClient;

    private final LightStateMapperInfra lightStateMapperInfra;


    @Override
    public void switchLight(boolean on, String bridgeId, int lightId) {
        diyHueClient.changeLightState(new StateRequest(on), bridgeId,lightId);
    }

    @Override
    public LightState getLightState(String bridgeId, int lightId) {
        return lightStateMapperInfra.mapLightStateResponseToLightState(diyHueClient.getLightState(bridgeId, lightId));
    }
}
