package com.batch.core.Thread;

import com.batch.core.model.BacthJobHander;
import com.batch.core.model.BacthParam;
import com.batch.core.model.TxResultResponse;
import org.eclipse.jetty.util.ConcurrentHashSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.LinkedBlockingDeque;

/**
 * @PACKAGE_NAME: com.batch.core.Thread
 * @PROJECT_NAME: batch-job
 * @Date: 2018/4/20
 * @author: Jossc
 * batch线程管理
 */
public class BacthJobThread extends  Thread{
    private static Logger logger = LoggerFactory.getLogger(BacthJobThread.class);
    private int jobId;
    private BacthJobHander bacthJobHander;
    private LinkedBlockingDeque<BacthParam> linkedBlockingDeque;
    private ConcurrentHashSet<Integer> concurrentHashSet;
    private volatile boolean threadStop = false;
    private String stopResone ;
    private volatile boolean running = false;
    private volatile int idleTimes = 0;

    public BacthJobThread (int jobId,BacthJobHander bacthJobHander) {
        this.jobId = jobId;
        this.bacthJobHander = bacthJobHander;
        this.concurrentHashSet = new ConcurrentHashSet<Integer>();
        this.linkedBlockingDeque = new LinkedBlockingDeque<>();
    }

    public BacthJobHander getBacthJobHander() {
        return bacthJobHander;
    }


    /**
     * 添加任务到队列中
     * @param bacthParam
     * @return
     */
    public TxResultResponse<String> pushTasktoQueue(BacthParam bacthParam){
        if (concurrentHashSet.contains(bacthParam)){
            logger.info(">>>>>------- 添加任务失败 已有 任务： " + bacthParam.getLogId());
            return new TxResultResponse<String>(TxResultResponse.FAIL,"add task fail :" + bacthParam.getJobId());
        }
        concurrentHashSet.add(bacthParam.getLogId());
        linkedBlockingDeque.add(bacthParam);
        return TxResultResponse.SUCCESS;
    }

    /**
     * 关闭线程
     * 线程自己的关闭并不优雅
     * 所以使用变量关闭
     * @param stopResone
     */
    public void threadToStop(String stopResone){
        this.threadStop = true;
        this.stopResone = stopResone;

    }

    /**
     * 队里中是否还有任务
     * @return
     */
    public boolean isiRunningQueue(){
        return running||linkedBlockingDeque.size()>0;
    }


}
