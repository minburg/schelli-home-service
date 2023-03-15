package dev.brgr.schellihomeservice.lighttimer.infrastructure.dto.mapper;

import dev.brgr.schellihomeservice.lighttimer.core.model.LightState;
import dev.brgr.schellihomeservice.lighttimer.infrastructure.dto.response.LightStateResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LightStateMapperInfra {
    @Mapping(target = "active", source = "lightState.state.on")

    LightState mapLightStateResponseToLightState(LightStateResponse lightState);
}
