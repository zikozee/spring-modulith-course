package com.zee.springmodulithcourse.eventaction;

import com.zee.springmodulithcourse.eventaction.action.Action;
import com.zee.springmodulithcourse.eventaction.action.RepublishUncompletedEvent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

@RestController
@RequestMapping(path = "event-action")
public class Controller {

    private final RepublishUncompletedEvent republishUncompletedEvent;

    public Controller(RepublishUncompletedEvent republishUncompletedEvent) {
        this.republishUncompletedEvent = republishUncompletedEvent;
    }

    @GetMapping
    public ResponseEntity<String> publishEvent(@RequestParam(name = "action") String action) {
        republishUncompletedEvent.republish(Action.getActionByName(action));
        return new ResponseEntity<>("Event Triggered", HttpStatus.NO_CONTENT);
    }
}
