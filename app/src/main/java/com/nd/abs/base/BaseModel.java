package com.nd.abs.base;

public class BaseModel<T> {
    private String info;
    private int status;   //1是成功，0是不成功
    private T data;

    public BaseModel(String message, int code) {
        this.info = message;
        this.status = code;
    }

    public int getErrcode() {
        return status;
    }

    public void setErrcode(int code) {
        this.status = code;
    }

    public String getErrmsg() {
        return info;
    }

    public void setErrmsg(String message) {
        this.info = message;
    }

    public T getData() {
        return data;
    }

    public void setDataBean(T result) {
        this.data = result;
    }

    @Override
    public String toString() {
        return "BaseModel{" +
                "code=" + status +
                ", msg='" + info + '\'' +
                ", result=" + data +
                '}';
    }
}
