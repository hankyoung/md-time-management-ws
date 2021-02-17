package com.knb.mdtimemanagement.time;

import com.knb.mdtimemanagement.common.BaseResponse;

public interface ActivityService {
    ActivityData create(ActivityEnum action, BaseResponse response);
}
