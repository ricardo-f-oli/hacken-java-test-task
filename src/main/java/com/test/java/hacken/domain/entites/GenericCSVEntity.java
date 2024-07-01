package com.test.java.hacken.domain.entites;

public class GenericCSVEntity {
    private String[] fields;

    public GenericCSVEntity(String[] fields) {
        this.fields = fields;
    }

    public String[] getFields() {
        return fields;
    }

    public void setFields(String[] fields) {
        this.fields = fields;
    }
}