package dev.brgr.schellihomeservice.lighttimer.core.service;

import dev.brgr.schellihomeservice.lighttimer.core.model.Timer;
import dev.brgr.schellihomeservice.lighttimer.core.model.TimerResponse;
import dev.brgr.schellihomeservice.lighttimer.core.ports.in.LightOperator;
import dev.brgr.schellihomeservice.lighttimer.core.ports.in.TimerCRUDOperations;
import dev.brgr.schellihomeservice.lighttimer.core.ports.out.ControlLight;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalTime;
import java.time.ZoneId;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Slf4j
public class LightOperatorService implements LightOperator {

    private final ControlLight controlLight;
    private final TimerCRUDOperations timerCRUDOperations;


    @Override
    public void checkAndApplyTimers() {
        TimerResponse allTimers = timerCRUDOperations.getAllTimers();
        List<Timer> activeTimers = allTimers.getTimers().stream().filter(Timer::isActive).collect(Collectors.toList());
        LocalTime now = LocalTime.now(ZoneId.of("Europe/Berlin"));

        activeTimers.forEach(timer -> {
            if (!now.isBefore(timer.getStartTime()) &&
                    now.isBefore(timer.getStartTime().plusSeconds(30))) {
                boolean on = true;
                logSwitching(timer, on);
                controlLight.switchLight(on, timer.getBridgeId().getValue(), timer.getLightId().getValue());
            }

            if(!now.isBefore(timer.getEndTime()) &&
                    now.isBefore(timer.getEndTime().plusSeconds(30))) {
                boolean on = false;
                logSwitching(timer, on);
                controlLight.switchLight(on, timer.getBridgeId().getValue(), timer.getLightId().getValue());
            }
        });
    }

    private void logSwitching(Timer timer, boolean on) {
        log.info("Switching light: {} for bridge: {} {}", timer.getLightId().getValue(), timer.getBridgeId().getValue(),
                (on ? "ON" : "OFF"));
    }
}
