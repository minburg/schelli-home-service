package dev.brgr.schellihomeservice.lighttimer.core.ports.in;


import dev.brgr.schellihomeservice.lighttimer.core.model.Timer;
import dev.brgr.schellihomeservice.lighttimer.core.model.TimerResponse;

public interface TimerCRUDOperations {

    TimerResponse getAllTimers();

    Timer createTimer(Timer mapTimerDtoToTimer);

    Timer toggleBypassTimer(long timerId);

    Timer changeTimer(Timer mapTimerDtoToTimer);

    void deleteTimer(long timerId);
}
