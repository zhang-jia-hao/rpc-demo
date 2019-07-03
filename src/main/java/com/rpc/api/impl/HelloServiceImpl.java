package com.rpc.api.impl;

import com.rpc.api.IHelloService;

public class HelloServiceImpl implements IHelloService {

	public String sayHello(String name) {
		return "Hello " + name + "!";
	}
}
