package com.mho.springboot.model.response;

import lombok.*;

@Getter @Setter
public class CommonResult {
    private boolean success;
    private Error error;

    @Getter @Setter
    @AllArgsConstructor
    public class Error {
        private int code;
        private String msg;
    }
}
