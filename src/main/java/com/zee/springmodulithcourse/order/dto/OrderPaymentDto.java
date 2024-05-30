package com.zee.springmodulithcourse.order.dto;

import org.jmolecules.event.types.DomainEvent;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */


public record OrderPaymentDto(String orderId, long amount) implements DomainEvent {
}
