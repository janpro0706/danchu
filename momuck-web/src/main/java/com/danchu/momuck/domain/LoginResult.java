package com.danchu.momuck.domain;

/**
 * LoginResult
 *
 * @author geine
 */
public enum LoginResult {

    SUCCESS(900, "Login success"),
    NOT_EXIST_EMAIL(901, "Not exist email"),
    NOT_CORRECT_PASSWORD(902, "Not correct password");

    private final int code;
    private final String message;

    LoginResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
