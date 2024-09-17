package com.zee.springmodulithcourse.order;

import com.zee.springmodulithcourse.order.dto.CompleteOrder;
import com.zee.springmodulithcourse.order.dto.EmailDto;
import com.zee.springmodulithcourse.order.dto.OrderPaymentDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@Service
public class OrderEventService {

    private static final Logger logger = LoggerFactory.getLogger(OrderEventService.class);

    private final ApplicationEventPublisher eventPublisher;

    public OrderEventService(ApplicationEventPublisher eventPublisher) {
        this.eventPublisher = eventPublisher;
    }

    @Transactional
    public void completeOrder(final OrderPaymentDto orderPaymentDto, EmailDto emailDto) {

        logger.info("Completing order payment with details{}", orderPaymentDto);
        eventPublisher.publishEvent(orderPaymentDto);

        logger.info("Sending email for order {}", emailDto);
        eventPublisher.publishEvent(emailDto);
    }

    @Transactional
    public void completePayment(CompleteOrder completeOrder, EmailDto emailDto) {
        logger.info("Attempting to complete payment {}", completeOrder);
        eventPublisher.publishEvent(completeOrder);

        logger.info("Completed payment Email {}", emailDto);
        eventPublisher.publishEvent(emailDto);
    }
}
