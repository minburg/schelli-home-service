package dev.brgr.schellihomeservice.growtimer.application.dto.mapper;

import dev.brgr.schellihomeservice.growtimer.application.dto.TimerDto;
import dev.brgr.schellihomeservice.growtimer.application.dto.TimerResponseDto;
import dev.brgr.schellihomeservice.growtimer.core.model.BridgeId;
import dev.brgr.schellihomeservice.growtimer.core.model.LightId;
import dev.brgr.schellihomeservice.growtimer.core.model.Timer;
import dev.brgr.schellihomeservice.growtimer.core.model.TimerResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TimerMapper {

    TimerResponseDto mapTimerResponseToTimerResponseDto(TimerResponse timers);

    @Mapping(target = "lightId", source = "timer.lightId.value")
    @Mapping(target = "bridgeId", source = "timer.bridgeId.value")
    TimerDto mapTimerToTimerDto(Timer timer);

    Timer mapTimerDtoToTimer(TimerDto timerDto);

    LightId mapIntToLightId(Integer value);

    BridgeId mapStringToBridgeId(String value);
}
