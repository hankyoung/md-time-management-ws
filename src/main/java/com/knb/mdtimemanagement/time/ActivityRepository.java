package com.knb.mdtimemanagement.time;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.Instant;
import java.util.List;

public interface ActivityRepository extends JpaRepository<ActivityDomain, Long> {
    List<ActivityDomain> findByActivityOrderByCreatedOnDesc(ActivityEnum activity);

    @Query("select a from ActivityDomain a where date(a.createdOn) = date(:date) order by a.createdOn")
    List<ActivityDomain> findActivityByDateOrderByCreatedOnDesc(@Param("date") Instant date);
}
