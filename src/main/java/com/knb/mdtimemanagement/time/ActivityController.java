package com.knb.mdtimemanagement.time;

import com.knb.mdtimemanagement.common.BaseResponse;
import com.knb.mdtimemanagement.common.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/v1/public")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @CrossOrigin
    @PostMapping("/activities")
    public ResponseEntity<BaseResponse> saveActivity(@RequestBody ActivityRequest data) {
        final BaseResponse response = new BaseResponse();
        activityService.create(data, response);
        if (response.getErrorCode().equals(ErrorCode.SUCCESS.value())) {
            response.setIsSuccess(Boolean.TRUE);
        } else {
            response.setIsSuccess(Boolean.FALSE);
        }
        return ResponseEntity.ok(response);
    }

    @CrossOrigin
    @GetMapping("/activities")
    public ResponseEntity<BaseResponse> getActivities(@RequestParam Long timestamp) {
        final BaseResponse response = new BaseResponse();
        List<ActivityData> activities = activityService.findActivitiesByDate(timestamp);
        if (activities == null || activities.isEmpty()) {
            response.setIsSuccess(Boolean.FALSE);
            response.setErrorCode(ErrorCode.NO_CONTENT.value());
        } else {
            response.setIsSuccess(Boolean.TRUE);
            response.setData(activities);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/admin/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Welcome to Minh Dang time management web services");
    }
}
