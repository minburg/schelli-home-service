package dev.brgr.schellihomeservice.growtimer.infrastructure.persistence;

import dev.brgr.schellihomeservice.growtimer.core.model.Timer;
import dev.brgr.schellihomeservice.growtimer.core.ports.out.TimerDatabaseOperations;
import dev.brgr.schellihomeservice.growtimer.infrastructure.dto.mapper.TimerMapperInfra;
import dev.brgr.schellihomeservice.growtimer.infrastructure.persistence.entity.TimerEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class TimerDatabaseAdapter implements TimerDatabaseOperations {
    private final TimerRepository timerRepository;
    private final TimerMapperInfra timerMapperInfra;

    @Override
    public List<Timer> getAllTimers() {
        return timerMapperInfra.mapTimerEntityListToTimerList(timerRepository.findAll());
    }

    @Override
    public Timer createTimer(Timer timer) {
        return timerMapperInfra.mapTimerEntityToTimer(timerRepository.save(timerMapperInfra.mapTimerToTimerEntity(timer)));
    }

    @Override
    public Timer toggleBypassTimer(long timerId) {
        Optional<TimerEntity> timer = timerRepository.findById(timerId);
        timer.ifPresentOrElse(timerEntity -> {
            boolean active = timerEntity.isActive();
            timerEntity.setActive(!active);
            timerRepository.save(timerEntity);
        }, () -> {
            throw new IllegalArgumentException("No timer found with id " + timerId);
        });

        return timerMapperInfra.mapTimerEntityToTimer(timer.get());
    }

    @Override
    public Timer changeTimer(Timer timer) {
        Optional<TimerEntity> timerEntity = timerRepository.findById(timer.getTimerId());
        timerEntity.ifPresentOrElse(timerEntity1 -> {
            setTimerValuesToTimerEntity(timer, timerEntity1);
            timerRepository.save(timerEntity1);
        }, () -> {
            throw new IllegalArgumentException("No timer found with id " + timer.getTimerId());
        });
        return timerMapperInfra.mapTimerEntityToTimer(timerEntity.get());
    }

    @Override
    public void deleteTimer(long timerId) {
        timerRepository.deleteById(timerId);
    }

    private void setTimerValuesToTimerEntity(Timer timer, TimerEntity timerEntity){
        timerEntity.setActive(timer.isActive());
        timerEntity.setLightId(timer.getLightId().getValue());
        timerEntity.setBridgeId(timer.getBridgeId().getValue());
        timerEntity.setStartTime(timer.getStartTime());
        timerEntity.setEndTime(timer.getEndTime());
    }
}
