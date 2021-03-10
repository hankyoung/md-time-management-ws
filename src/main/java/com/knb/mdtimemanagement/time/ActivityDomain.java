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
    private Boolean mamaMilk;

    public ActivityDomain(ActivityRequest data) {
        createdOn = Instant.ofEpochSecond(data.getCreatedOn());
        status = StatusEnum.ACTIVE;
        activity = ActivityEnum.getEnum(data.getActivity());
        volume = data.getVolume();
        mamaMilk = data.getIsMamaMilk();
        if (activity.equals(ActivityEnum.SLEEP)) startTime = Instant.ofEpochSecond(data.getCreatedOn());
    }
}
