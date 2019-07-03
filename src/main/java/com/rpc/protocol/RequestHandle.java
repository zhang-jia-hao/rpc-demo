package com.rpc.protocol;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import com.rpc.framework.Invocation;
import com.rpc.framework.UrlFactory;
import com.rpc.register.Register;

/**
 * 具体请求处理类
 * @author zhang
 *
 */
public class RequestHandle {

	public void handle(InputStream in,OutputStream out){
		try {
			ObjectInputStream obj = new ObjectInputStream(in);
			Invocation invocation = (Invocation) obj.readObject();
			
			String interfaceName = invocation.getInterfaceName();//注册服务名

			Class<?> clazz = Register.getServiceImplClass(interfaceName, UrlFactory.getLocalUrl());//注册中心取到实现类

			Method method = clazz.getMethod(invocation.getMethodName(), invocation.getParamTypes());//执行方法

			Object invoke = method.invoke(clazz.newInstance(), invocation.getParams());//invoke

			ObjectOutputStream outputStream = new ObjectOutputStream(out);//获取输出流
			outputStream.writeObject(invoke);//返回
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
