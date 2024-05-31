package com.zee.springmodulithcourse.eventaction;

import com.zee.springmodulithcourse.eventaction.action.Action;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

@Entity
@Getter
@Setter
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
}
