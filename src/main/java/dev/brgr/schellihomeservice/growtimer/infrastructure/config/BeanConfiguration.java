package dev.brgr.schellihomeservice.growtimer.infrastructure.config;

import dev.brgr.schellihomeservice.growtimer.core.ports.in.TimerCRUDOperations;
import dev.brgr.schellihomeservice.growtimer.core.ports.out.ControlGrowLight;
import dev.brgr.schellihomeservice.growtimer.core.ports.out.TimerDatabaseOperations;
import dev.brgr.schellihomeservice.growtimer.core.service.LightOperatorService;
import dev.brgr.schellihomeservice.growtimer.core.service.TimerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    LightOperatorService growTimerService(ControlGrowLight controlGrowLight, TimerCRUDOperations timerCRUDOperations) {
        return new LightOperatorService(controlGrowLight, timerCRUDOperations);
    }

    @Bean
    TimerService timerService(TimerDatabaseOperations timerDatabaseOperations) {
        return new TimerService(timerDatabaseOperations);
    }
}
