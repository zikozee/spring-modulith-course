package com.zee.springmodulithcourse.eventpublication;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */


public interface CustomEventPublicationService {

    List<CustomEventPublication> getUncompletedEventPublications();
    List<CustomEventPublication> getCompletedEventPublications();
}
