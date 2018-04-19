package com.batch.core.batchnetwork.client;

import com.batch.core.batchException.BacthExecption;
import com.batch.core.batchSerializer.BatchSerializer;
import com.batch.core.rpc.modelEc.BatchRpcRequest;
import com.batch.core.rpc.modelEc.BatchRpcResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



/**
 * @PACKAGE_NAME: com.batch.core.batchnetwork.client
 * @PROJECT_NAME: batch-job
 * @Date: 2018/4/19
 * @author: Jossc
 * 客户端
 */
public class BatchClient {
    private static Logger
        logger  = LoggerFactory.getLogger(BatchClient.class);

    /**
     * 发送消息
     * 接受结果
     * @param request
     * @return
     */
    public BatchRpcResponse sendMessage(BatchRpcRequest request){
        byte[] requestBytes = BatchSerializer.serialize(request);
        return null;
    }
}
