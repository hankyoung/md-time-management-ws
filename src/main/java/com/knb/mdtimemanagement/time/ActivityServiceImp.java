package com.knb.mdtimemanagement.time;

import com.knb.mdtimemanagement.common.BaseResponse;
import com.knb.mdtimemanagement.common.ErrorCode;
import com.knb.mdtimemanagement.common.MessageService;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityServiceImp implements ActivityService {

    private final ActivityRepository activityRepository;
    private final MessageService messageService;

    public ActivityServiceImp(ActivityRepository activityRepository, MessageService messageService) {
        this.activityRepository = activityRepository;
        this.messageService = messageService;
    }

    @Override
    public ActivityData create(ActivityRequest data, BaseResponse response) {
        ActivityEnum action = ActivityEnum.getEnum(data.getActivity());
        ActivityDomain activity = new ActivityDomain(data);
        List<ActivityDomain> sleepActivities = findRecentActivityBy(ActivityEnum.SLEEP)
                .stream().filter(a -> a.getStatus().equals(StatusEnum.IN_PROGRESS)).collect(Collectors.toList());
        if (action.equals(ActivityEnum.SLEEP)) {
            if (!sleepActivities.isEmpty()) {
                response.setMessage(messageService.getMessage("err.sleep.activity.in.progress"));
                response.setErrorCode(ErrorCode.INSERT_FAIL.value());
                return null;
            }
            activity.setStatus(StatusEnum.IN_PROGRESS);
        } else if (action.equals(ActivityEnum.WAKE)) {
            if (sleepActivities.isEmpty()) {
                response.setMessage(messageService.getMessage("err.no.sleep.activity.in.progress"));
                response.setErrorCode(ErrorCode.INSERT_FAIL.value());
                return null;
            }
            ActivityDomain sleepActivity = sleepActivities.get(0);
            sleepActivity.setEndTime(Instant.now());
            sleepActivity.setStatus(StatusEnum.ACTIVE);
            activityRepository.save(sleepActivity);
            activity.setFromActivityId(sleepActivity.getId());
        }

        ActivityData activityData = populateActivityDTO(activityRepository.save(activity));
        response.setErrorCode(ErrorCode.SUCCESS.value());
        response.setMessage(messageService.getMessage("insert.data.success"));
        response.setData(activityData);
        return activityData;
    }

    private List<ActivityDomain> findRecentActivityBy(ActivityEnum activity) {
        return activityRepository.findByActivityOrderByCreatedOnDesc(activity);
    }

    private ActivityData populateActivityDTO(ActivityDomain activity) {
        ActivityData activityData = new ActivityData();
        activityData.setId(activity.getId());
        activityData.setCreatedOn(activity.getCreatedOn());
        activityData.setStatus(activity.getStatus());
        activityData.setStatusName(activity.getStatus().getStatusName());
        activityData.setActivity(activity.getActivity());
        activityData.setActivityDesc(activity.getActivity().getActivityDesc());
        activityData.setIsMamaMilk(activity.getMamaMilk());
        return activityData;
    }
}
