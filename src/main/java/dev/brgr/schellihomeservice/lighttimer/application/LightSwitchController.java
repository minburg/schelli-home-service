package dev.brgr.schellihomeservice.lighttimer.application;

import dev.brgr.schellihomeservice.lighttimer.application.dto.LightStateDto;
import dev.brgr.schellihomeservice.lighttimer.application.dto.LightSwitchDto;
import dev.brgr.schellihomeservice.lighttimer.application.dto.TimerDto;
import dev.brgr.schellihomeservice.lighttimer.application.dto.mapper.LightStateMapper;
import dev.brgr.schellihomeservice.lighttimer.application.dto.mapper.TimerMapper;
import dev.brgr.schellihomeservice.lighttimer.core.ports.in.LightStateOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api-v1")
public class LightSwitchController {
    private final LightStateMapper lightStateMapper;
    private final LightStateOperation lightStateOperation;

    @GetMapping("/light")
    public ResponseEntity<LightStateDto> getLightState(@RequestParam String bridgeId, @RequestParam int lightId) {
        return ResponseEntity.ok(lightStateMapper.mapLightStateToLightStateDto(lightStateOperation.getLightState(bridgeId, lightId)));
    }

    @PutMapping("/light")
    public ResponseEntity<LightStateDto> switchLight(@RequestBody LightSwitchDto lightSwitchDto) {
        return ResponseEntity.ok(lightStateMapper.mapLightStateToLightStateDto(lightStateOperation.switchLight(lightStateMapper.mapLightSwitchDtoToLightSwitch(lightSwitchDto))));

    }

}
