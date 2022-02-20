package dev.brgr.schellihomeservice.growtimer.core.ports.out;

public interface ControlGrowLight {
    void switchGrowLight(boolean on, String bridgeId, int lightId);
}
