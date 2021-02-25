package com.knb.mdtimemanagement.time;

import com.knb.mdtimemanagement.common.BaseResponse;
import com.knb.mdtimemanagement.common.ErrorCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/public")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }

    @PostMapping("/activities")
    public ResponseEntity<BaseResponse> saveActivity(@RequestParam ActivityEnum action) {
        final BaseResponse response = new BaseResponse();
        activityService.create(action, response);
        if (response.getErrorCode().equals(ErrorCode.SUCCESS.value())) {
            response.setIsSuccess(Boolean.TRUE);
        } else {
            response.setIsSuccess(Boolean.FALSE);
        }
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/admin/test")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("Welcome to Minh Dang time management web services");
    }
}
