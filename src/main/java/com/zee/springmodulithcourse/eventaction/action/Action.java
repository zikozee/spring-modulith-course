package com.zee.springmodulithcourse.eventaction.action;

import java.util.Arrays;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

public enum Action {
    PAYMENT("P"), EMAIL("E"), COMPLETE_PAYMENT("C");

    private final String code;

    public static Action getActionByName(final String name){
        return Arrays.stream(Action.values())
                .filter(action -> action.name().equalsIgnoreCase(name))
                .findFirst().orElse(null);
    }

    Action(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
