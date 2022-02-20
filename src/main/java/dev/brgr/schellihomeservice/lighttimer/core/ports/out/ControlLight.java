package dev.brgr.schellihomeservice.lighttimer.core.ports.out;

public interface ControlLight {
    void switchLight(boolean on, String bridgeId, int lightId);
}
