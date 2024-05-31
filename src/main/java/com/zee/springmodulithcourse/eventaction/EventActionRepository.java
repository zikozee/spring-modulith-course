package com.zee.springmodulithcourse.eventaction;

import com.zee.springmodulithcourse.eventaction.action.Action;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

@Repository
public interface EventActionRepository extends CrudRepository<EventAction, Long> {
    Optional<EventAction> getEventActionByAction(Action action);
}
