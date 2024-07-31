package com.spring.crud_students.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

//@Entity
//@Table(name = "string")
public class StringEntity {

    private String key;
    private String value;

    public StringEntity() {
    }

    public StringEntity(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
