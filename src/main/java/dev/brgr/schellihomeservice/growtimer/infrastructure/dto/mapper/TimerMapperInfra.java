package dev.brgr.schellihomeservice.growtimer.infrastructure.dto.mapper;

import dev.brgr.schellihomeservice.growtimer.core.model.BridgeId;
import dev.brgr.schellihomeservice.growtimer.core.model.LightId;
import dev.brgr.schellihomeservice.growtimer.core.model.Timer;
import dev.brgr.schellihomeservice.growtimer.infrastructure.persistence.entity.TimerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TimerMapperInfra {

    Timer mapTimerEntityToTimer(TimerEntity timerEntity);

    List<Timer> mapTimerEntityListToTimerList(List<TimerEntity> timers);

    LightId mapIntToLightId(Integer value);

    BridgeId mapStringToBridgeId(String value);

    @Mapping(target = "lightId", source = "timer.lightId.value")
    @Mapping(target = "bridgeId", source = "timer.bridgeId.value")
    @Mapping(target = "timerId", ignore = true)
    TimerEntity mapTimerToTimerEntity(Timer timer);
}
