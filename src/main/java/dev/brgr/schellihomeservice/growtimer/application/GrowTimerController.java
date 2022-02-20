package dev.brgr.schellihomeservice.growtimer.application;

import dev.brgr.schellihomeservice.growtimer.application.dto.TimerDto;
import dev.brgr.schellihomeservice.growtimer.application.dto.TimerResponseDto;
import dev.brgr.schellihomeservice.growtimer.application.dto.mapper.TimerMapper;
import dev.brgr.schellihomeservice.growtimer.core.ports.in.TimerCRUDOperations;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api-v1")
public class GrowTimerController {
    private final TimerMapper timerMapper;
    private final TimerCRUDOperations timerCRUDOperations;

    @GetMapping("/all-timers")
    public TimerResponseDto getAllTimers() {
        return timerMapper.mapTimerResponseToTimerResponseDto(timerCRUDOperations.getAllTimers());
    }

    @PostMapping("/timer")
    public ResponseEntity<TimerDto> createTimer(@RequestBody TimerDto timerDto) {
        return ResponseEntity.ok(timerMapper.mapTimerToTimerDto(timerCRUDOperations.createTimer(
                timerMapper.mapTimerDtoToTimer(timerDto))));
    }

    @PatchMapping("/timer/{timerId}/toggle-bypass")
    public ResponseEntity<TimerDto> toggleBypassTimer(@PathVariable("timerId") long timerId) {
        return ResponseEntity.ok(timerMapper.mapTimerToTimerDto(timerCRUDOperations.toggleBypassTimer(timerId)));
    }

    @PutMapping("/timer")
    public ResponseEntity<TimerDto> changeTimer(@RequestBody TimerDto timerDto) {
        return new ResponseEntity<>(timerMapper.mapTimerToTimerDto(timerCRUDOperations.changeTimer(
                timerMapper.mapTimerDtoToTimer(timerDto))), HttpStatus.CREATED);
    }

    @DeleteMapping("/timer/{timerId}")
    public ResponseEntity<Object> deleteTimer(@PathVariable("timerId") long timerId) {
        timerCRUDOperations.deleteTimer(timerId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
