package com.zee.springmodulithcourse.eventpublication;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ApplicationModuleTest
class EventPublicationIntegrationTest {

    @Autowired
    CustomEventPublicationService service;


    @Test
    void getUncompletedEventPublicationTest(){

        List<CustomEventPublication> uncompletedEventPublications = service.getUncompletedEventPublications();

        uncompletedEventPublications
                .forEach(ev -> {
                   assertThat(ev).isInstanceOf(CustomEventPublication.class);
                   assertThat(ev.getCompletionDate()).isNull();
                });
    }

    @Test
    void getCompletedEventPublicationTest(){

        List<CustomEventPublication> uncompletedEventPublications = service.getCompletedEventPublications();

        uncompletedEventPublications
                .forEach(ev -> {
                    assertThat(ev).isInstanceOf(CustomEventPublication.class);
                    assertThat(ev.getCompletionDate()).isNotNull();
                });
    }
}