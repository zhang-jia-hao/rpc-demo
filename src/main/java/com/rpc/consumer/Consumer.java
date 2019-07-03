package com.rpc.consumer;

import com.rpc.api.IHelloService;

/**
 * 客户端类
 * @author zhang
 *
 */
public class Consumer {
	public static void main(String[] args) {
		//获取代理对象
		IHelloService proxyConsumer = ProxyConsumer.getProxyConsumer(IHelloService.class);
		System.out.println(proxyConsumer.sayHello("world"));//执行
	}
}
