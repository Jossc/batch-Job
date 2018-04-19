package com.batch.core.batchSerializer;

import com.batch.core.BatchException.BatchRuntimeExecption;
import com.caucho.hessian.io.HessianInput;
import com.caucho.hessian.io.HessianOutput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * @PACKAGE_NAME: com.batch.core.batchSerializer
 * @PROJECT_NAME: batch-job
 * @Date: 2018/4/19
 * @author: Jossc
 */
public class BatchSerializer {
    private static final Logger logger = LoggerFactory.getLogger(BatchSerializer.class);

    /**
     * serialize object
     * response/request
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> byte[]  serialize(T obj){
        try(ByteArrayOutputStream os = new ByteArrayOutputStream()){
            HessianOutput hessianOutput = new HessianOutput(os);
            hessianOutput.writeObject(obj);
            return os.toByteArray();
        } catch (IOException exception) {
            logger.error(exception.getMessage());
            return  null;
        }
    }

    /**
     * deserialized object
     * response/request
     * @param bytes
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> Object deserialized(byte[] bytes, Class<T> clazz){
        try(ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes)){
            HessianInput hessianInput = new HessianInput(byteArrayInputStream);
            return  hessianInput.readObject();
        } catch (IOException exception) {
            logger.error(exception.getMessage());
            return  null;
        }
    }

}
