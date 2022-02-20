package dev.brgr.schellihomeservice.growtimer.application;

import dev.brgr.schellihomeservice.growtimer.core.ports.in.LightOperator;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class TimerScheduler {
    private final LightOperator lightOperator;

    @Scheduled(cron = "0 * * * * *")
    public void checkAndApplyTimers(){
        lightOperator.checkAndApplyTimers();
    }
}
