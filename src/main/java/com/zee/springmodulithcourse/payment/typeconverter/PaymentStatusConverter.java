package com.zee.springmodulithcourse.payment.typeconverter;

import com.zee.springmodulithcourse.payment.type.PaymentStatus;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import com.zee.springmodulithcourse.exception.*;

import java.util.Arrays;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@Converter(autoApply = true)
public class PaymentStatusConverter implements AttributeConverter<PaymentStatus, String> {
    @Override
    public String convertToDatabaseColumn(PaymentStatus status) {
        if(status == null) throw new ModulithException("Status can not be null");
        return status.getCode();
    }

    @Override
    public PaymentStatus convertToEntityAttribute(String code) {
        if(code == null) throw new IllegalArgumentException("Code can not be null");
        return Arrays.stream(PaymentStatus.values())
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst().orElseThrow(ModulithException::new);
    }
}
