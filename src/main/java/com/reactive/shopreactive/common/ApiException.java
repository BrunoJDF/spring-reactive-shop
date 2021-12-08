package com.reactive.shopreactive.common;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ApiException {
    private int statusCode;
    private String message;
    private LocalDateTime dateTime;
}
