package com.batch.core.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;

/**
 * @PACKAGE_NAME: com.batch.core.util
 * @PROJECT_NAME: batch-job
 * @Date: 2018/4/19
 * @author: Jossc
 * httpclient util
 */
public class HttpClientUtil {
    private static Logger logger
            = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * post 请求
     * @param reqURL
     * @param data
     * @return
     */
    public static  byte[] postRequest(String reqURL, byte[] data){
        byte[] responseBytes = null;
        HttpPost httpPost = new HttpPost(reqURL);
        CloseableHttpClient httpClient = HttpClients.custom().
                disableAutomaticRetries().build();
        try {
            RequestConfig requestConfig
                    = RequestConfig.custom()
                    .setConnectionRequestTimeout(10000)
                    .setSocketTimeout(10000)
                    .setConnectTimeout(10000)
                    .build();
            httpPost.setConfig(requestConfig);
            if(null != data){
                httpPost.setEntity(new ByteArrayEntity(data,ContentType.DEFAULT_BINARY));
            }
            HttpResponse response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            if(null != entity){
                responseBytes = EntityUtils.toByteArray(entity);
                EntityUtils.consume(entity);
            }

        }catch (Exception e){
            logger.error("message : " + e.getMessage());
        }finally {
            httpPost.releaseConnection();
            try {
                httpClient.close();
            } catch (IOException ioe) {
                logger.error(ioe.getMessage(), ioe);
            }
        }
        return responseBytes;
    }

    /**
     * 读取 request
     * @param request
     * @return
     */
    public static byte[] readBytes(HttpServletRequest request){
        try {
            request.setCharacterEncoding("UTF-8");
            int contentLen = request.getContentLength();
            InputStream inputStream = request.getInputStream();
            if(contentLen>0){
                int readLen = 0;
                int readtTime = 0;
                byte[] message = new byte[contentLen];
                while (readLen!= contentLen){
                    readtTime = inputStream.read(message,readLen,
                            contentLen - readLen);
                    if(readLen == -1){
                        break;
                    }
                    readLen += readtTime;
                }
                return message;
            }
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            e.printStackTrace();
        }
        return new byte[]{};
    }

}
