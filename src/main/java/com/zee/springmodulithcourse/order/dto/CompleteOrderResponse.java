package com.zee.springmodulithcourse.order.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.jmolecules.event.types.DomainEvent;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
*/

public record CompleteOrderResponse(boolean paymentComplete) { }
