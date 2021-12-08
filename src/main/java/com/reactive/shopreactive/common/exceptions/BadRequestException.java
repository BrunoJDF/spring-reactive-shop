package com.reactive.shopreactive.common.exceptions;

public class BadRequestException extends Exception {
    public BadRequestException(String description) {
        super(description);
    }
}
