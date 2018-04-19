package com.batch.core.BatchException;

import java.util.Random;

/**
 * @PACKAGE_NAME: com.batch.core.BatchException
 * @PROJECT_NAME: batch-job
 * @Date: 2018/4/19
 * @author: Jossc
 */
public class BacthExecption extends Exception {
    private static final long serialVersionUID = new Random().nextLong();
    public BacthExecption() {

    }

    public BacthExecption(String message) {
        super(message);
    }
}
