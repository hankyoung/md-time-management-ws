package com.knb.mdtimemanagement.time;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.Instant;

@Data
public class ActivityData {
    private Long id;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Instant createdOn;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Instant startTime;
    @JsonFormat(shape = JsonFormat.Shape.NUMBER)
    private Instant endTime;
    private StatusEnum status;
    private String statusName;
    private ActivityEnum activity;
    private String activityDesc;
    private Long volume;
    private Boolean isMamaMilk;
}
