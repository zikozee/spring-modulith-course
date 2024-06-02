package com.zee.springmodulithcourse.eventaction.action;

import com.zee.springmodulithcourse.eventaction.EventAction;
import com.zee.springmodulithcourse.eventaction.EventActionRepository;
import com.zee.springmodulithcourse.exception.ModulithException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.core.env.Environment;
import org.springframework.modulith.events.CompletedEventPublications;
import org.springframework.modulith.events.IncompleteEventPublications;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Duration;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class RepublishUncompletedEvent {

    private final EventActionRepository eventActionRepository;
    private final IncompleteEventPublications incompleteEventPublications;
    private final CompletedEventPublications completedEventPublications;
    private final Environment env;


    public void republish(Action action) {
        Optional<EventAction> optionalEventAction = eventActionRepository.getEventActionByAction(action);

        if(optionalEventAction.isEmpty()){
            log.info("No event action found for action: {}", action);
        }

        if(optionalEventAction.isPresent()){
            log.info("Republish uncompleted events for Action {}", action);
            EventAction eventAction = optionalEventAction.get();

            try {
                final Class<?> actionClass = Class.forName(eventAction.getEventCanonicalName());
                incompleteEventPublications.resubmitIncompletePublications((ep) -> ep.getEvent().getClass() == actionClass);
//                completedEventPublications.deletePublicationsOlderThan(Duration.ofHours(env.getProperty("delete.event.duration", Long.class, 100L)));
            } catch (ClassNotFoundException e) {
                throw new ModulithException(e.getMessage());
            }
        }
    }

    public void republish(List<Action> actions) {
        actions.forEach(this::republish);
    }

//    @Scheduled(fixedRate = 10L, timeUnit = TimeUnit.SECONDS)
    public void republish() {
        log.info("Republishing uncompleted events");
        for(Action action: Action.values()){
            republish(action);
        }
    }
}
