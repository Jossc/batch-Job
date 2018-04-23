package com.batch.core.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;

/**
 * @PACKAGE_NAME: com.batch.core.util
 * @PROJECT_NAME: batch-job
 * @Date: 2018/4/23
 * @author: Jossc
 *
 */
public class FileUtil {
    private  static  final Logger logger = LoggerFactory.getLogger(FileUtil.class);
    /**
     * 递归删除
     * @param root
     * @return
     */
    public boolean  deleteResourceFile(File root){
        if(root != null && root.exists()){
            if(root.isDirectory()){
                File[] childen = root.listFiles();
                if(childen.length>0){
                    for(File d : childen){
                        deleteResourceFile(d);
                    }
                }
            }
            return  root.delete();
        }
        return false;
    }
}
