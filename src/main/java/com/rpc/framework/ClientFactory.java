package com.rpc.framework;

import com.rpc.protocol.http.HttpClient;
import com.rpc.protocol.tcp.TcpClient;

public class ClientFactory {

	public static Client getClient() {
		String property = System.getProperty("Protocol");

		if ("tcp".equals(property)) {
			return new TcpClient();
		}

		return new HttpClient();
	}
}
