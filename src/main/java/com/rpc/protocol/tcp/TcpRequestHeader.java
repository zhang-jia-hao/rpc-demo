package com.rpc.protocol.tcp;

import java.io.IOException;
import java.net.Socket;
import com.rpc.protocol.RequestHandle;

public class TcpRequestHeader extends RequestHandle implements Runnable {

	private Socket socket;

	TcpRequestHeader(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		// TODO Auto-generated method stub
		try {
			super.handle(socket.getInputStream(), socket.getOutputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.shutdownInput();
				socket.shutdownOutput();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
