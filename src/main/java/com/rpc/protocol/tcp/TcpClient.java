package com.rpc.protocol.tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import com.rpc.framework.Client;
import com.rpc.framework.Invocation;

public class TcpClient implements Client {

	@SuppressWarnings("all")
	public Object send(String host, int port, Invocation invocation) {
		// TODO Auto-generated method stub
		Socket socket = null;
		ObjectOutputStream objectOutputStream = null;
		ObjectInputStream objectInputStream = null;
		try {
			socket = new Socket(host, port);
			objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
			objectOutputStream.writeObject(invocation);
			objectOutputStream.flush();

			objectInputStream = new ObjectInputStream(socket.getInputStream());
			return objectInputStream.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (objectOutputStream != null) {
					objectOutputStream.close();
				}
				if (objectInputStream != null) {
					objectInputStream.close();
				}

				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return null;
	}
}
