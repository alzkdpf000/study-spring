package com.example.mysql.enumeration;

public enum Status {
    ACTIVE("active"), INACTIVE("inactive");

    private String value;

    Status(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
