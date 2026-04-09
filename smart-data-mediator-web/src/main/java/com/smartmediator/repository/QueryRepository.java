package com.smartmediator.repository;

import com.smartmediator.entity.QueryHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QueryRepository extends JpaRepository<QueryHistory, Long> {

    List<QueryHistory> findTop10ByOrderByCreatedAtDesc();

}