package com.zee.springmodulithcourse.eventaction;

import com.zee.springmodulithcourse.eventaction.action.Action;
import jakarta.persistence.*;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

@Entity
@Table(indexes = {
    @Index(name = "actionIdx", columnList = "action")
})
public class EventAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 2, nullable = false)
    private Action action;
    @Column(name = "event_can", nullable = false)
    private String eventCanonicalName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public String getEventCanonicalName() {
        return eventCanonicalName;
    }

    public void setEventCanonicalName(String eventCanonicalName) {
        this.eventCanonicalName = eventCanonicalName;
    }
}
