package com.knb.mdtimemanagement.time;

import lombok.Data;

@Data
public class ActivityRequest {
    private Long createdOn;
    private String activity;
    private Long volume;
    private Boolean isMamaMilk;
}
