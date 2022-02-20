package dev.brgr.schellihomeservice.growtimer.core.ports.in;


import dev.brgr.schellihomeservice.growtimer.core.model.Timer;
import dev.brgr.schellihomeservice.growtimer.core.model.TimerResponse;

public interface TimerCRUDOperations {

    TimerResponse getAllTimers();

    Timer createTimer(Timer mapTimerDtoToTimer);

    Timer toggleBypassTimer(long timerId);

    Timer changeTimer(Timer mapTimerDtoToTimer);

    void deleteTimer(long timerId);
}
