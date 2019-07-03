package com.rpc.protocol.http;

import java.io.InputStream;
import java.io.OutputStream;
import com.rpc.protocol.RequestHandle;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpRequestHandle extends RequestHandle {

	public void doPost(HttpServletRequest req, HttpServletResponse resp) {
		try {
			super.handle(req.getInputStream(),resp.getOutputStream());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
