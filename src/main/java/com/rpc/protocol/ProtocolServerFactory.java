package com.rpc.protocol;

import com.rpc.protocol.http.HttpServer;
import com.rpc.protocol.tcp.TcpServer;

public class ProtocolServerFactory {

	public static ProtocolServer getProtocolServer() {
		String property = System.getProperty("Protocol");//获取系统属性，默认http

		if ("tcp".equals(property)) {
			return new TcpServer();
		}

		return new HttpServer();
	}
}
