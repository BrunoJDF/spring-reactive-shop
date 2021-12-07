package com.reactive.shopreactive.common;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiException {
    private int statusCode;
    private String message;
    private Throwable throwable;

}
