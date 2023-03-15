package dev.brgr.schellihomeservice.lighttimer.core.ports.in;


import dev.brgr.schellihomeservice.lighttimer.core.model.LightState;
import dev.brgr.schellihomeservice.lighttimer.core.model.LightSwitch;
import dev.brgr.schellihomeservice.lighttimer.core.model.Timer;
import dev.brgr.schellihomeservice.lighttimer.core.model.TimerResponse;

public interface LightStateOperation {

    LightState getLightState(String bridgeId, int lightId);

    LightState switchLight(LightSwitch lightSwitch);
}
