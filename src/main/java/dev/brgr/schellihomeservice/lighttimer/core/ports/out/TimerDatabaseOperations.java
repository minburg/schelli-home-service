package dev.brgr.schellihomeservice.lighttimer.core.ports.out;


import dev.brgr.schellihomeservice.lighttimer.core.model.Timer;

import java.util.List;

public interface TimerDatabaseOperations {

    List<Timer> getAllTimers();

    Timer createTimer(Timer timer);

    Timer toggleBypassTimer(long timerId);

    Timer changeTimer(Timer timer);

    void deleteTimer(long timerId);
}
