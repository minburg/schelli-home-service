package dev.brgr.schellihomeservice.lighttimer.infrastructure.rest;

import dev.brgr.schellihomeservice.config.FeignLoggerConfiguration;
import dev.brgr.schellihomeservice.lighttimer.infrastructure.dto.request.StateRequest;
import dev.brgr.schellihomeservice.lighttimer.infrastructure.dto.response.LightStateResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "diyHueClient", url = "${external-api.diyhue.host}", configuration = FeignLoggerConfiguration.class)
public interface DiyHueClient {

    @PutMapping(path = "/api/{bridgeId}/lights/{lightId}/state")
    List<LightStateResponse> changeLightState(
            @RequestBody StateRequest stateRequest,
            @PathVariable("bridgeId") String bridgeId,
            @PathVariable("lightId") int lightId
    );


}
