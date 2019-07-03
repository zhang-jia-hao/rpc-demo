package com.rpc.consumer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import com.rpc.framework.ClientFactory;
import com.rpc.framework.Invocation;
import com.rpc.framework.Url;
import com.rpc.register.Register;

/**
 * 返回 代理对象
 * @author zhang
 *
 * @param <T>
 */
public class ProxyConsumer<T> {

	@SuppressWarnings("unchecked")
	public static <T> T getProxyConsumer(final Class<?> clazz) {

		return (T) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[] { clazz }, new InvocationHandler() {

			public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
				// TODO Auto-generated method stub
				Invocation invocation = new Invocation(clazz.getName(), method.getName(), args,method.getParameterTypes());
				Url serviceUrl = Register.getServiceUrl(clazz.getName());//注册中心获取地址
				return ClientFactory.getClient().send(serviceUrl.getHost(), serviceUrl.getPort(), invocation);
			}
		});
	}

}
