package com.batch.core.rpc.modelEc;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Random;

/**
 * @PACKAGE_NAME: com.batch.core.rpc.modelEc
 * @PROJECT_NAME: batch-job
 * @Date: 2018/4/19
 * @author: Jossc
 * request 请求
 */
public class BatchRpcRequest implements Serializable {
    private static  long  serialVersionUID = new Random().nextLong();

    /**
     * 服务器地址
     */
    private String serverAddress;
    /**
     * 创建时间
     */
    private long createMillisTime;
    /**
     * token
     */
    private String accessToken;
    /**
     * 类名
     */
    private String className;
    /**
     * 方法名字
     */
    private String methodName;
    /**
     * 参数类型
     */
    private Class<?>[] parameterTypes;
    /**
     * 参数
     */
    private Object[] parameters;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public static void setSerialVersionUID(long serialVersionUID) {
        BatchRpcRequest.serialVersionUID = serialVersionUID;
    }

    public String getServerAddress() {
        return serverAddress;
    }

    public void setServerAddress(String serverAddress) {
        this.serverAddress = serverAddress;
    }

    public long getCreateMillisTime() {
        return createMillisTime;
    }

    public void setCreateMillisTime(long createMillisTime) {
        this.createMillisTime = createMillisTime;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Class<?>[] getParameterTypes() {
        return parameterTypes;
    }

    public void setParameterTypes(Class<?>[] parameterTypes) {
        this.parameterTypes = parameterTypes;
    }

    public Object[] getParameters() {
        return parameters;
    }

    public void setParameters(Object[] parameters) {
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "BatchRpcRequest{" +
                "serverAddress='" + serverAddress + '\'' +
                ", createMillisTime=" + createMillisTime +
                ", accessToken='" + accessToken + '\'' +
                ", className='" + className + '\'' +
                ", methodName='" + methodName + '\'' +
                ", parameterTypes=" + Arrays.toString(parameterTypes) +
                ", parameters=" + Arrays.toString(parameters) +
                '}';
    }
}
