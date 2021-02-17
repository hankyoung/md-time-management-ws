package com.knb.mdtimemanagement.time;

import lombok.Data;

import java.time.Instant;

@Data
public class ActivityData {
    private Long id;
    private Instant createdOn;
    private StatusEnum status;
    private String statusName;
    private ActivityEnum activity;
    private String activityDesc;
}
