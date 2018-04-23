package com.batch.core.util;

import com.batch.core.batchException.BacthExecption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * @PACKAGE_NAME: com.batch.core.util
 * @PROJECT_NAME: batch-job
 * @Date: 2018/4/23
 * @author: Jossc
 * 监控端口
 * 返回端口
 */
public class BatchNetUtil {
    private  static Logger logger = LoggerFactory.getLogger(BatchNetUtil.class);

    /**
     * 寻找有效的端口
     * @return
     */
    public static int findRunProt(int defaultPort) throws BacthExecption {
        int portTmp = defaultPort;
        while (portTmp< 65535){
            if(!isProtUsed(portTmp)){
                return  portTmp;
            }else {
                portTmp ++;
            }
        }
        portTmp = defaultPort --;
        while (portTmp>0){
            if(!isProtUsed(portTmp)){
                return  portTmp;
            }else {
                portTmp --;
            }
        }
        throw new BacthExecption("no available port.");
    }

    /**
     * 直接去socket连接
     * 连不上就被用
     * @param port
     * @return
     */
    public static  boolean isProtUsed(int port){
        boolean used = false;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            used = false;
        } catch (IOException e) {
            logger.debug(">>>>>port  is in using ", port);
            used = true;
        }finally {
            if(serverSocket!= null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    logger.info("serverSocket close");
                }
            }
        }
        return used;
    }
}
