package com.knb.mdtimemanagement.time;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<ActivityDomain, Long> {
    List<ActivityDomain> findByActivityOrderByCreatedOnDesc(ActivityEnum activity);
}
