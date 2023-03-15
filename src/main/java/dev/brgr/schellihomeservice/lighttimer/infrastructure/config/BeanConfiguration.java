package dev.brgr.schellihomeservice.lighttimer.infrastructure.config;

import dev.brgr.schellihomeservice.lighttimer.core.ports.in.TimerCRUDOperations;
import dev.brgr.schellihomeservice.lighttimer.core.ports.out.ManageLight;
import dev.brgr.schellihomeservice.lighttimer.core.ports.out.TimerDatabaseOperations;
import dev.brgr.schellihomeservice.lighttimer.core.service.LightOperatorService;
import dev.brgr.schellihomeservice.lighttimer.core.service.TimerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {

    @Bean
    LightOperatorService lightOperatorService(ManageLight manageLight, TimerCRUDOperations timerCRUDOperations) {
        return new LightOperatorService(manageLight, timerCRUDOperations);
    }

    @Bean
    TimerService timerService(TimerDatabaseOperations timerDatabaseOperations) {
        return new TimerService(timerDatabaseOperations);
    }
}
