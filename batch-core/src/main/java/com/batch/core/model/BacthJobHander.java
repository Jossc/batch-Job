package com.batch.core.model;

/**
 * PACKAGE_NAME: com.batch.core.model
 * MONTH_NAME_SHORT: 四月
 * USER: Clement
 **/
public abstract class BacthJobHander {
    //success
    public static  final TxResultResponse<String>
        SUCCESS = new TxResultResponse<>(200,null);
    //fail
    public static final TxResultResponse<String>
       FAIL = new TxResultResponse<>(500,null);
    // retry
    public static final TxResultResponse<String>
        RETRY = new TxResultResponse<>(501,null);


    /**
     * 执行器
     *
     * @param param
     * @return
     * @throws Exception
     */
    public abstract  TxResultResponse<String> execute(String param) throws Exception;


    /**
     * 初始化
     */
    public void init(){

    }

    /**
     *
     */
    public void destory(){

    }



}
