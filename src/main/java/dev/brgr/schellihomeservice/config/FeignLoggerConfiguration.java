package dev.brgr.schellihomeservice.config;

import dev.brgr.schellihomeservice.SchelliHomeServiceApplication;
import feign.Logger;
import feign.slf4j.Slf4jLogger;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@EnableFeignClients(basePackageClasses = SchelliHomeServiceApplication.class)
@Configuration
public class FeignLoggerConfiguration {

    @Bean
    public feign.Logger logger(){
        return new Slf4jLogger();
    }

    @Bean
    public Logger.Level feignLoggerLevel(){
        return Logger.Level.BASIC;
    }
}
