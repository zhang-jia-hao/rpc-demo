package com.rpc.provider;

import com.rpc.api.IHelloService;
import com.rpc.api.impl.HelloServiceImpl;
import com.rpc.framework.Url;
import com.rpc.framework.UrlFactory;
import com.rpc.protocol.ProtocolServerFactory;
import com.rpc.register.Register;
/**
 * 服务提供者
 * @author zhang
 *
 */
public class Provider {
	public static void main(String[] args) {
		Url url = UrlFactory.getLocalUrl();//获取本机注册的url

		Register.RegisterService(url, IHelloService.class.getName(), HelloServiceImpl.class);//注册到服务中心

		ProtocolServerFactory.getProtocolServer().startup(url);//启动服务
	}
}
