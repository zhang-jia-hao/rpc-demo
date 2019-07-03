package com.rpc.framework;

public class UrlFactory {

	public static Url getLocalUrl() {
		return new Url("localhost", 8081);
	}
}
