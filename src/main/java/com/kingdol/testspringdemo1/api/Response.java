package com.kingdol.testspringdemo1.api;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Date;

@Slf4j
@Data
public class Response<T> {
    //...省略其他代码
    private T data;
    private String message;
    private int code;
    private String timestamp;

    public Response() {
        this.timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
    }

    public void success(T data) {
        this.setData(data);
        this.setMessage("Success!");
        this.setCode(200);
    }

    public void setError(String message, int code) {
        this.setCode(code);
        this.setMessage(message);
    }

    public static <T> Response<T> ok(T data) {
        Response<T> response = new Response<>();
        response.success(data);
        return response;
    }

    public static <T> Response<T> error(String message, int code) {
        Response<T> response = new Response<>();
        response.setError(message, code);
        return response;
    }
}
