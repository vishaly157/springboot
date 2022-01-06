package com.example.demo.model;

public class ResponseModel<T>{

    private String info;
    private T data;
    private boolean success;

    public ResponseModel(String info, T data, boolean success) {
        this.info = info;
        this.data = data;
        this.success = success;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
