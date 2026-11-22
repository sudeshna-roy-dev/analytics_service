
package com.analytics.analytics_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "click_events")
public class ClickEventEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID eventId;

    @Column(nullable = false, length = 20)
    private String shortCode;

    @Column(nullable = false)
    private Instant clickedAt;

    @Column(length = 255)
    private String source;

    @Column(length = 255)
    private String campaign;

    public ClickEventEntity() {
    }

    public ClickEventEntity(UUID eventId, String shortCode,
                            Instant clickedAt, String source,
                            String campaign) {
        this.eventId = eventId;
        this.shortCode = shortCode;
        this.clickedAt = clickedAt;
        this.source = source;
        this.campaign = campaign;
    }

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }

    public Instant getClickedAt() {
        return clickedAt;
    }

    public void setClickedAt(Instant clickedAt) {
        this.clickedAt = clickedAt;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }
}
