package com.zhw.algorithm.framework.protocol.http;

import com.zhw.algorithm.framework.Invocation;
import org.apache.commons.io.IOUtils;

import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @Author zhw
 * @since 2022/7/6
 */
public class HttpClient {

    public String send(String hostName, Integer port, Invocation invocation){
        //配置
        try {
            URL url = new URL("http",hostName,port,"/");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();

            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);

            OutputStream outputStream = httpURLConnection.getOutputStream();
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

            objectOutputStream.writeObject(invocation);
            objectOutputStream.flush();
            objectOutputStream.close();

            InputStream inputStream = httpURLConnection.getInputStream();
            String result = IOUtils.toString(inputStream);
            return result;
        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
