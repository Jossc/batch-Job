package com.batch.core.Thread;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @PACKAGE_NAME: com.batch.core.Thread
 * @PROJECT_NAME: batch-job
 * @Date: 2018/4/23
 * @author: Jossc
 */
public class FileCleanThread extends  Thread {
    private Logger logger = LoggerFactory.getLogger(FileCleanThread.class);

    private  static FileCleanThread instance = new FileCleanThread();
    private  static FileCleanThread getInstance(){
        return  instance;
    }
    private Thread localThread;
    //停止线程 外部停止
    private  volatile  boolean stopThread = false;

    public void stat(long logDay){
        if(logDay <3){
            return;
        }
        localThread = new Thread(()->{
            while (!stopThread){
                try {

                }catch (Exception bacthExecption){
                    logger.error("error : ",bacthExecption);
                }
            }
        });
    }

    /**
     * 外部中断
     */
    public void toStopThread(){
        stopThread = true;
        if(localThread ==null){
            return;
        }
        localThread.interrupt();
        try {
            localThread.join();
        } catch (InterruptedException e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
    }
}
