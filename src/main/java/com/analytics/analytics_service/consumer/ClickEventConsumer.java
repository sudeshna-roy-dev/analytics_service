
package com.analytics.analytics_service.consumer;

import com.analytics.analytics_service.event.ClickEvent;
import com.analytics.analytics_service.entity.ClickEventEntity;
import com.analytics.analytics_service.repository.ClickEventRepository;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ClickEventConsumer {

    private final ClickEventRepository clickEventRepository;

    public ClickEventConsumer(ClickEventRepository clickEventRepository) {
        this.clickEventRepository = clickEventRepository;
    }

    @KafkaListener(
            topics = "url-click-events",
            groupId = "analytics-group"
    )
    public void consume(ClickEvent clickEvent) {

        ClickEventEntity entity = new ClickEventEntity(
                clickEvent.getEventId(),
                clickEvent.getShortCode(),
                clickEvent.getClickedAt(),
                clickEvent.getSource(),
                clickEvent.getCampaign()
        );

        if (!clickEventRepository.existsById(clickEvent.getEventId())) {
            clickEventRepository.save(entity);
            System.out.println("Click event saved: " + clickEvent.getShortCode());
        } else {
            System.out.println("Duplicate event ignored: " + clickEvent.getEventId());
        }

        System.out.println("Click event saved: " + clickEvent.getShortCode());
    }
}
