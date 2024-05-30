package com.zee.springmodulithcourse.payment;


import com.zee.springmodulithcourse.order.dto.OrderPaymentDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentEventService {

    private final PaymentRepository paymentRepository;

    @ApplicationModuleListener
    void on(final OrderPaymentDto paymentDto) {
        log.info("Order payment received in listener: {}", paymentDto);
    }
}
