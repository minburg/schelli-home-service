package dev.brgr.schellihomeservice.lighttimer.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CorsFilterConfiguration {

    @Bean
    public FilterRegistrationBean<CustomCorsFilter> headerValidatorFilter() {
        FilterRegistrationBean<CustomCorsFilter> registrationBean = new FilterRegistrationBean<>();
        registrationBean.setFilter(new CustomCorsFilter());
        registrationBean.addUrlPatterns("*");
        return registrationBean;
    }
}
