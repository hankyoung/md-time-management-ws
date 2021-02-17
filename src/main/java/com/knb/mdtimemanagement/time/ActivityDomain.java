package com.knb.mdtimemanagement.time;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "activity")
public class ActivityDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant createdOn;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    @Enumerated(EnumType.STRING)
    private ActivityEnum activity;
    private Instant startTime;
    private Instant endTime;
    private Long volume;
    private Long fromActivityId;

    public ActivityDomain(ActivityEnum action) {
        createdOn = Instant.now();
        status = StatusEnum.ACTIVE;
        activity = action;
        if (action.equals(ActivityEnum.SLEEP)) startTime = Instant.now();
    }
}
