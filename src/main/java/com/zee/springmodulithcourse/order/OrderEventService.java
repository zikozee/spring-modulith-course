package com.zee.springmodulithcourse.order;

import com.zee.springmodulithcourse.order.dto.OrderPaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderEventService {

    private final ApplicationEventPublisher eventPublisher;

    @Transactional
    public void completeOrder(final OrderPaymentDto orderPaymentDto) {

        log.info("Completing order payment with details{}", orderPaymentDto);
        eventPublisher.publishEvent(orderPaymentDto);
    }
}
