package com.zee.springmodulithcourse.payment.type;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 30 May, 2024
 */

public enum PaymentStatus {
    INCOMPLETE("I"), COMPLETED("C"), FAILED("F");

    private final String code;

    PaymentStatus(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
