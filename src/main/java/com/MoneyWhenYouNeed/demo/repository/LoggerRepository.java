package com.MoneyWhenYouNeed.demo.repository;

import com.MoneyWhenYouNeed.demo.entity.LoggerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoggerRepository extends JpaRepository<LoggerEntity, Long> {
}
