package com.analytics.analytics_service.consumer;

import com.analytics.analytics_service.event.ClickEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ClickEventConsumer {

    @KafkaListener(topics = "url-click-events", groupId = "analytics-group")
    public void consume(ClickEvent clickEvent) {

        System.out.println("Received click event: " + clickEvent.getShortCode());

    }

}
