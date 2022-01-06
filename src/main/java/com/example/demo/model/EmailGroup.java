package com.example.demo.model;

import org.springframework.stereotype.Component;


//@Component
public enum EmailGroup {
    gmail("@gmail.com"),
    hotmail("@hotmail.com"),
    yahoo("@yahoo.com");

    private String label;

    EmailGroup(String label) {
        this.label = label;
    }

    public String getLabel() {
        return this.label;
    }
}