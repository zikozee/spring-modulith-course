package com.zee.springmodulithcourse.order.type;


/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

public enum Status {

    OPEN("O"), COMPLETED("C");

    private final String code;

    Status(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
