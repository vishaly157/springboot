package com.example.demo.model;

public class StatsGroup {

    private int key;
    private long value;

    public StatsGroup(int key, Long val) {
        this.key = key;
        this.value = val;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public long getValue() {
        return value;
    }

    public void setValue(long value) {
        this.value = value;
    }
}

