package dev.brgr.schellihomeservice.growtimer.infrastructure.persistence;

import dev.brgr.schellihomeservice.growtimer.infrastructure.persistence.entity.TimerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimerRepository extends JpaRepository<TimerEntity, Long> {
}
