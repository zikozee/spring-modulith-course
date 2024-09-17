package com.zee.springmodulithcourse.email;

import com.zee.springmodulithcourse.order.dto.EmailDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.modulith.events.ApplicationModuleListener;
import org.springframework.stereotype.Component;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

@Component
public class EmailService {
    private static final Logger logger = LoggerFactory.getLogger(EmailService.class);

    @ApplicationModuleListener
    void sendEmail(final EmailDto emailDto) {

        logger.info("Email properties received");

        if(!emailDto.orderComplete()) {
            String body = "Dear "  + emailDto.customerName() + ",\n" +
                    "An Order was initialized with Id: " + emailDto.orderIdentifier() + "and total sum of: N" +
                    + emailDto.totalAmount()/100;
            logger.info("initial Email order details: {}", body);
        }else {
            String body = "Dear "  + emailDto.customerName() + ",\n" +
                    "Your order with Id: " + emailDto.orderIdentifier() + "and total sum of: N" +
                    + emailDto.totalAmount()/100 + " was completed successfully";
            logger.info("Email completion details: {}", body);
        }
        logger.info("Email sent to {}", emailDto.email());
    }
}
