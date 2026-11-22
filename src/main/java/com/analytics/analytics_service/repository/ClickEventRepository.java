package com.analytics.analytics_service.repository;

import com.analytics.analytics_service.entity.ClickEventEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ClickEventRepository extends JpaRepository<ClickEventEntity, UUID> {

    boolean existsById(UUID eventId);

}