package com.zhw.algorithm.framework.protocol.http;

import com.zhw.algorithm.framework.Invocation;
import com.zhw.algorithm.framework.register.LocalRegister;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @Author zhw
 * @since 2022/7/6
 */
public class HttpServerHandler {

    public void handler(HttpServletRequest req, HttpServletResponse resp){
        //处理请求
        try {
            Invocation invocation = (Invocation)new ObjectInputStream(req.getInputStream()).readObject();

            //执行方法
            String interfaceName = invocation.getInterfaceName();

            Class clazz = LocalRegister.get(interfaceName);

            Method method = clazz.getMethod(invocation.getMethodName(), invocation.getParamType());

            String invoke = (String) method.invoke(clazz.newInstance(), invocation.getParams());

            IOUtils.write(invoke, resp.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
