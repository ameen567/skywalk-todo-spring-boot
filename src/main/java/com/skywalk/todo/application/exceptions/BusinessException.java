package com.skywalk.todo.application.exceptions;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public abstract class BusinessException extends RuntimeException {
    private boolean userError;

    BusinessException(String message, boolean userError) {
        super(message);
        this.userError = userError;
    }

    BusinessException(String message, Throwable cause, boolean userError) {
        super(message, cause);
        this.userError = userError;
    }
}
