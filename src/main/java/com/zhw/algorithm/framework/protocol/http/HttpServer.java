package com.zhw.algorithm.framework.protocol.http;

import com.zhw.algorithm.http.impl.TomcatHttpServlet;
import org.apache.catalina.*;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.core.StandardEngine;
import org.apache.catalina.core.StandardHost;
import org.apache.catalina.startup.Tomcat;

/**
 * @Author zhw
 * @since 2022/7/6
 */
public class HttpServer {

    /**
     * 启动服务端口
     * @param hostName
     * @param port
     */
    public void start(String appName,String contextPath,String hostName,Integer port){
        Tomcat tomcat = new Tomcat();
        //tomcat 调用getServer 会自动实例化 名称为“Tomcat” 的Service
        Server server = tomcat.getServer();
        Service service = server.findService("Tomcat");

        //设置 绑定端口
        Connector connector = new Connector();
        connector.setPort(port);

        //一个Service最多只能由一个Engine
        Engine engine = new StandardEngine();
        engine.setDefaultHost(hostName);

        //代表一个虚拟主机，或者说一个站点，可以给Tomcat配置多个虚拟主机地址，而一个虚拟主机下可以包含多个Context
        Host host = new StandardHost();
        host.setName(hostName);

        Context context = new StandardContext();
        context.setPath(contextPath);
        context.addLifecycleListener(new Tomcat.FixContextListener());

        host.addChild(context);
        engine.addChild(host);

        service.setContainer(engine);
        service.addConnector(connector);

        //暴露端口&链接
        tomcat.addServlet(contextPath, appName, new DispatchcherServlet());
        context.addServletMappingDecoded("/*",appName);

        try {
            tomcat.start();
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
