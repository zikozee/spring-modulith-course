package com.zee.springmodulithcourse.order.dto;


import com.zee.springmodulithcourse.eventaction.action.Action;
import com.zee.springmodulithcourse.eventaction.action.CustomEventMarker;
import jakarta.validation.constraints.NotBlank;
import org.jmolecules.event.types.DomainEvent;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

@CustomEventMarker(eventAction = Action.COMPLETE_PAYMENT)
public record CompleteOrder(
        @NotBlank(message = "orderIdentifier is required")
        String orderIdentifier,
        boolean paymentComplete) implements DomainEvent { }
