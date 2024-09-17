package com.zee.springmodulithcourse.eventpublication;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.UUID;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

@Entity
@Table(name = "event_publication")
public class CustomEventPublication {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String listenerId;
    private String eventType;
    private String serializedEvent;
    private Timestamp publicationDate;
    private Timestamp completionDate;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getListenerId() {
        return listenerId;
    }

    public void setListenerId(String listenerId) {
        this.listenerId = listenerId;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getSerializedEvent() {
        return serializedEvent;
    }

    public void setSerializedEvent(String serializedEvent) {
        this.serializedEvent = serializedEvent;
    }

    public Timestamp getPublicationDate() {
        return publicationDate;
    }

    public void setPublicationDate(Timestamp publicationDate) {
        this.publicationDate = publicationDate;
    }

    public Timestamp getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(Timestamp completionDate) {
        this.completionDate = completionDate;
    }

    @Override
    public String toString() {
        return "CustomEventPublication{" +
                "id=" + id +
                ", listenerId='" + listenerId + '\'' +
                ", eventType='" + eventType + '\'' +
                ", serializedEvent='" + serializedEvent + '\'' +
                ", publicationDate=" + publicationDate +
                ", completionDate=" + completionDate +
                '}';
    }
}

