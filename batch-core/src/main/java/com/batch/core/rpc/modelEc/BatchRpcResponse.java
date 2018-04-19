package com.batch.core.rpc.modelEc;

import java.io.Serializable;
import java.util.Random;

/**
 * @PACKAGE_NAME: com.batch.core.rpc.modelEc
 * @PROJECT_NAME: batch-job
 * @Date: 2018/4/19
 * @author: Jossc
 * response 响应
 */
public class BatchRpcResponse implements Serializable {
    private static final long  serialVersionUID = new Random().nextLong();

    /**
     * 返回结果
     */
    private Object result;

    /**
     * c错误信息
     */
    private String error;

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "BatchRpcResponse{" +
                "result=" + result +
                ", error='" + error + '\'' +
                '}';
    }
}
