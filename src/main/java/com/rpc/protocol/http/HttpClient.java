package com.rpc.protocol.http;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import com.rpc.framework.Client;
import com.rpc.framework.Invocation;

public class HttpClient implements Client {

	/**
	 * 发送请求
	 * 
	 * @param host
	 *            域名ip地址
	 * @param port
	 *            端口
	 * @param invocation
	 *            传输对象
	 * @return
	 */
	public Object send(String host, int port, Invocation invocation) {
		ObjectOutputStream dos = null;
		ObjectInputStream inputStream = null;
		try {
			URL url = new URL("http://" + host + ":" + port);
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			// 设置通用的请求属性
			httpURLConnection.setRequestProperty("connection", "Keep-Alive");
			httpURLConnection.setRequestProperty("content-type", "application/x-www-form-urlencoded;charset=UTF-8");
			httpURLConnection.setRequestMethod("POST");
			// 发送POST请求必须设置如下两行
			httpURLConnection.setDoOutput(true);
			httpURLConnection.setDoInput(true);
			httpURLConnection.setUseCaches(false); // 不允许缓存

			// 获取输出流
			dos = new ObjectOutputStream(httpURLConnection.getOutputStream());
			dos.writeObject(invocation);
			dos.flush();
			dos.close();

			// 得到响应流
			inputStream = new ObjectInputStream(httpURLConnection.getInputStream());
			return inputStream.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (dos != null) {
					dos.close();
				}
				if (inputStream != null) {
					inputStream.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return null;
	}
}
