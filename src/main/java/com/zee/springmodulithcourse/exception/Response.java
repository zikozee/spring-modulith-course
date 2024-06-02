package com.zee.springmodulithcourse.exception;

import org.springframework.http.HttpStatus;

/**
 * @author : Ezekiel Eromosei
 * @code @created : 02 Jun, 2024
 */


public record Response(String message, HttpStatus status) {
}
