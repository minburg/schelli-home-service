package dev.brgr.schellihomeservice.lighttimer.core.ports.out;

import dev.brgr.schellihomeservice.lighttimer.core.model.LightState;

public interface ManageLight {
    void switchLight(boolean on, String bridgeId, int lightId);
    LightState getLightState(String bridgeId, int lightId);
}
