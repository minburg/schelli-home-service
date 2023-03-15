package dev.brgr.schellihomeservice.lighttimer.application.dto.mapper;

import dev.brgr.schellihomeservice.lighttimer.application.dto.LightStateDto;
import dev.brgr.schellihomeservice.lighttimer.application.dto.LightSwitchDto;
import dev.brgr.schellihomeservice.lighttimer.core.model.LightState;
import dev.brgr.schellihomeservice.lighttimer.core.model.LightSwitch;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LightStateMapper {

    LightStateDto mapLightStateToLightStateDto(LightState lightState);

    LightSwitch mapLightSwitchDtoToLightSwitch(LightSwitchDto lightSwitchDto);
}
