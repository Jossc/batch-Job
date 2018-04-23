package com.batch.core.model;

import java.io.Serializable;

/**
 * @PACKAGE_NAME: com.batch.core.model
 * @PROJECT_NAME: batch-job
 * @Date: 2018/4/23
 * @author: Jossc
 * 返回编码
 */
public class TxResultResponse<T> implements Serializable {
    public static final long serialVersionUID = 11213L;
    public static final int SUCESS_CODE = 200;
    public static final int FAIL_CODE = 500;
    public static final TxResultResponse<String> SUCCESS
             = new TxResultResponse<>(null);
    public static  final TxResultResponse<String>
         FAIL =new TxResultResponse<String>(FAIL_CODE,null);
    private  int code ;
    private  String msg;
    private  T content;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    public TxResultResponse(){

    }

    public TxResultResponse(int code,String msg){
        this.code = code;
        this.msg = msg;
    }
    public TxResultResponse(T content){
        this.code = SUCESS_CODE;
        this.content = content;
    }


    @Override
    public String toString() {
        return "TxResultResponse{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", content=" + content +
                '}';
    }
}
