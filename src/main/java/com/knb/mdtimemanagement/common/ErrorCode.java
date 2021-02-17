package com.knb.mdtimemanagement.common;

public enum ErrorCode {
    SUCCESS("00"),
    NO_CONTENT("01"),
    INSERT_FAIL("02");

    private final String value;

    ErrorCode(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
