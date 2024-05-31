package com.zee.springmodulithcourse.order.dto;

import com.zee.springmodulithcourse.eventaction.action.Action;
import com.zee.springmodulithcourse.eventaction.action.CustomEventMarker;
import org.jmolecules.event.types.DomainEvent;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@CustomEventMarker(eventAction = Action.PAYMENT)
public record OrderPaymentDto(String orderId, long amount) implements DomainEvent {
}
