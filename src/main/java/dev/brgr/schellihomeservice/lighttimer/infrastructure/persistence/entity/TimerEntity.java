package dev.brgr.schellihomeservice.lighttimer.infrastructure.persistence.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalTime;

@Entity
@Getter
@Setter
public class TimerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long timerId;
    @Column(nullable = false)
    private Integer lightId;
    @Column(nullable = false)
    private String bridgeId;
    @Column(nullable = false)
    private LocalTime startTime;
    @Column(nullable = false)
    private LocalTime endTime;
    @Column(nullable = false)
    private boolean active;
}
