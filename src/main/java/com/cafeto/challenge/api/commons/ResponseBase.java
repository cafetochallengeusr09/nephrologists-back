package com.cafeto.challenge.api.commons;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Builder
@Data
public class ResponseBase {

    private Integer code;
    private String message;
    private Object body;

    public static ResponseBase buildSuccessResponse(Object body) {
        return ResponseBase.builder()
                .code(0)
                .message("success")
                .body(body)
                .build();
    }

    public static ResponseBase buildSuccessWithOutBodyResponse() {
        return ResponseBase.builder()
                .code(0)
                .message("success")
                .build();
    }

    public static ResponseBase buildErrorResponse(String errorMessage) {
        return ResponseBase.builder()
                .code(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .message(errorMessage)
                .build();
    }

}
