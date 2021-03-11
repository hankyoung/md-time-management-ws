package com.knb.mdtimemanagement.time;

import com.knb.mdtimemanagement.common.BaseResponse;

import java.util.List;

public interface ActivityService {
    ActivityData create(ActivityRequest data, BaseResponse response);

    List<ActivityData> findActivitiesByDate(Long timeStamp);
}
