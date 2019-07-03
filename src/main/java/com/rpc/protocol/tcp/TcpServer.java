package com.rpc.protocol.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import com.rpc.framework.Url;
import com.rpc.protocol.ProtocolServer;

public class TcpServer implements ProtocolServer {

	@SuppressWarnings("resource")
	public void startup(Url url) {
		try {
			ServerSocket socketServer = new ServerSocket(url.getPort());
			System.out.println("socket 监听启动");
			while (true) {
				Socket accept = socketServer.accept();
				new Thread(new TcpRequestHeader(accept)).start();
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
