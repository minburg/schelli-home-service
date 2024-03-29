package dev.brgr.schellihomeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;


@ImportAutoConfiguration({FeignAutoConfiguration.class})
@SpringBootApplication
public class SchelliHomeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(SchelliHomeServiceApplication.class, args);
    }

}
