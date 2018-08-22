package com.santech.hongbao.app.http;

import java.io.IOException;

/**
 */

public class ServicesException extends IOException {

    private int code;

    private String msg;

    public ServicesException(int code, String msg) {
        super(msg);
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
