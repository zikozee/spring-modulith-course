package com.zee.springmodulithcourse.eventaction.action;

import java.lang.annotation.*;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 31 May, 2024
 */

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface CustomEventMarker {

    Action eventAction();
}
