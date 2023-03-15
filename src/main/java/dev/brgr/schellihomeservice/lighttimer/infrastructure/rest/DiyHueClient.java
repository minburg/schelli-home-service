package dev.brgr.schellihomeservice.lighttimer.infrastructure.rest;

import dev.brgr.schellihomeservice.config.FeignLoggerConfiguration;
import dev.brgr.schellihomeservice.lighttimer.infrastructure.dto.request.StateRequest;
import dev.brgr.schellihomeservice.lighttimer.infrastructure.dto.response.LightStateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "diyHueClient", url = "${external-api.diyhue.host}", configuration = FeignLoggerConfiguration.class)
public interface DiyHueClient {

    @GetMapping(path = "/api/{bridgeId}/lights/{lightId}")
    LightStateResponse getLightState(
            @PathVariable("bridgeId") String bridgeId,
            @PathVariable("lightId") int lightId
    );

    @PutMapping(path = "/api/{bridgeId}/lights/{lightId}/state")
    void changeLightState(
            @RequestBody StateRequest stateRequest,
            @PathVariable("bridgeId") String bridgeId,
            @PathVariable("lightId") int lightId
    );


}
