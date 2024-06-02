package com.zee.springmodulithcourse.order.typeconverter;

import com.zee.springmodulithcourse.exception.ModulithException;
import com.zee.springmodulithcourse.order.type.Status;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.Arrays;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@Converter(autoApply = true)
public class StatusConverter implements AttributeConverter<Status, String> {

    @Override
    public String convertToDatabaseColumn(Status status) {
        return Arrays.stream(Status.values())
                .filter(s -> s == status)
                .map(Status::getCode)
                .findFirst().orElseThrow(() -> new ModulithException("No status found"));
    }

    @Override
    public Status convertToEntityAttribute(String code) {
        return Arrays.stream(Status.values())
                .filter(s -> s.getCode().equalsIgnoreCase(code))
                .findFirst().orElseThrow(() -> new ModulithException("No status found"));
    }
}
