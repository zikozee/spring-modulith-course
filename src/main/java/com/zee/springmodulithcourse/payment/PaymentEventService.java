package com.zee.springmodulithcourse.payment;


import com.zee.springmodulithcourse.order.dto.CompleteOrder;
import com.zee.springmodulithcourse.order.dto.OrderPaymentDto;
import com.zee.springmodulithcourse.payment.type.PaymentStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@Component
public class PaymentEventService {
    private static final Logger logger = LoggerFactory.getLogger(PaymentEventService.class);

    private final PaymentRepository paymentRepository;

    public PaymentEventService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @ApplicationModuleListener
    void on(final OrderPaymentDto paymentDto) {
        logger.info("Order payment received in listener: {}", paymentDto);

        Payment payment = new Payment();
        payment.setOrderId(paymentDto.orderId());
        payment.setAmount(paymentDto.amount());
        paymentRepository.save(payment);
    }

    @ApplicationModuleListener
    void completeOrder(final CompleteOrder completeOrder) {

        logger.info("Complete order received in listener: {}", completeOrder);

        Optional<Payment> optionalPayment = paymentRepository.getPaymentsByOrderId(completeOrder.orderIdentifier());

        if (optionalPayment.isPresent()) {
            Payment payment = optionalPayment.get();
            payment.setStatus(PaymentStatus.COMPLETED);
            paymentRepository.save(payment);
        }
    }
}
