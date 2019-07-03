package com.rpc.protocol.http;

import org.apache.catalina.Context;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.startup.Tomcat;
import com.rpc.framework.Url;
import com.rpc.protocol.ProtocolServer;

public class HttpServer implements ProtocolServer {

	/**
	 * 协议服务启动类
	 * 
	 * @param url
	 */
	@SuppressWarnings("all")
	public void startup(Url url) {
		try {
			Tomcat tomcat = new Tomcat();// 内置tomcat

			tomcat.setHostname(url.getHost());// 设置地址端口
			tomcat.setPort(url.getPort());
			tomcat.setBaseDir(".");// 设置文件夹

			Context ctx = tomcat.addContext("/", null);// 网络访问路径

			tomcat.addServlet(ctx, "servlet", DispatcherServlet.class.getCanonicalName()); // 配置servlet
			ctx.addServletMapping("/*", "servlet");

			tomcat.getServer().addLifecycleListener(new AprLifecycleListener());// 监听器
			tomcat.start();
			tomcat.getServer().await();// 启动监听
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
