package com.zee.springmodulithcourse.eventpublication;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

@Service
@RequiredArgsConstructor
public class CustomEventPublicationServiceImpl implements CustomEventPublicationService {
    private final CustomEventPublicationRepository customEventPublicationRepository;

    @Override
    public List<CustomEventPublication> getUncompletedEventPublications() {
        return customEventPublicationRepository.getEventPublicationsByPublicationDateNotNullAndCompletionDateIsNull();
    }

    @Override
    public List<CustomEventPublication> getCompletedEventPublications() {
        return customEventPublicationRepository.getEventPublicationsByPublicationDateNotNullAndCompletionDateNotNull();
    }
}
