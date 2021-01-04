package com.github.peng49.minirpc;

import lombok.Data;

@Data
public class Response {
    /**
     * 服务返回编码， 0 - 成功 ，非0失败
     */
    private int code = 0;
    private String message = "ok";
    private Object data;
}
