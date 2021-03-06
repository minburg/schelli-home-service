package dev.brgr.schellihomeservice.lighttimer.core.service;

import dev.brgr.schellihomeservice.lighttimer.core.model.Timer;
import dev.brgr.schellihomeservice.lighttimer.core.model.TimerResponse;
import dev.brgr.schellihomeservice.lighttimer.core.ports.in.TimerCRUDOperations;
import dev.brgr.schellihomeservice.lighttimer.core.ports.out.TimerDatabaseOperations;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class TimerService implements TimerCRUDOperations {

    private final TimerDatabaseOperations timerDatabaseOperations;

    @Override
    public TimerResponse getAllTimers() {
        return new TimerResponse(timerDatabaseOperations.getAllTimers());
    }

    @Override
    public Timer createTimer(Timer timer) {
        return timerDatabaseOperations.createTimer(timer);
    }

    @Override
    public Timer toggleBypassTimer(long timerId) {
        return timerDatabaseOperations.toggleBypassTimer(timerId);
    }

    @Override
    public Timer changeTimer(Timer timer) {
        return timerDatabaseOperations.changeTimer(timer);
    }

    @Override
    public void deleteTimer(long timerId) {
        timerDatabaseOperations.deleteTimer(timerId);
    }
}
