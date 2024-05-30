package com.zee.springmodulithcourse.order.type;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

@Getter
@AllArgsConstructor
public enum Status {

    OPEN("O"), COMPLETED("C");

    private final String code;
}
