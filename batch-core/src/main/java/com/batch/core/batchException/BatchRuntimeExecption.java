package com.batch.core.batchException;

import java.util.Random;

/**
 * @PACKAGE_NAME: com.batch.core.batchException
 * @PROJECT_NAME: batch-job
 * @Date: 2018/4/19
 * @author: Jossc
 */
public class BatchRuntimeExecption extends RuntimeException {
    private static final long serialVersionUID = new Random().nextLong();
    public BatchRuntimeExecption(){
        super();
    }

    public BatchRuntimeExecption(String message){
        super(message);
    }

}
