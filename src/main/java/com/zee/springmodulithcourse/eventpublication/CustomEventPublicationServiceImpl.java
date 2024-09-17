package com.zee.springmodulithcourse.eventpublication;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

@Service
//@RequiredArgsConstructor
public class CustomEventPublicationServiceImpl implements CustomEventPublicationService {
    private final CustomEventPublicationRepository customEventPublicationRepository;

    public CustomEventPublicationServiceImpl(CustomEventPublicationRepository customEventPublicationRepository) {
        this.customEventPublicationRepository = customEventPublicationRepository;
    }

    @Override
    public List<CustomEventPublication> getUncompletedEventPublications() {
        return customEventPublicationRepository.getEventPublicationsByPublicationDateNotNullAndCompletionDateIsNull();
    }

    @Override
    public List<CustomEventPublication> getCompletedEventPublications() {
        return customEventPublicationRepository.getEventPublicationsByPublicationDateNotNullAndCompletionDateNotNull();
    }
}
