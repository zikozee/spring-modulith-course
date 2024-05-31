package com.zee.springmodulithcourse.eventpublication;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

@Repository
public interface CustomEventPublicationRepository extends CrudRepository<CustomEventPublication, Long> {
    List<CustomEventPublication> getEventPublicationsByPublicationDateNotNullAndCompletionDateIsNull();
    List<CustomEventPublication> getEventPublicationsByPublicationDateNotNullAndCompletionDateNotNull();
}
