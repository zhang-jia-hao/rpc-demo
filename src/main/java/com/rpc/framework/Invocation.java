package com.rpc.framework;

import java.io.Serializable;

public class Invocation implements Serializable {

	/**
	 * 传输对象
	 */
	private static final long serialVersionUID = 184655656L;
    //接口服务名称
	private String interfaceName;
    //方法名称
	private String methodName;
    //参数列表
	private Object[] params;
    //参数类型列表
	private Class<?>[] paramTypes;

	public Invocation(String interfaceName, String methodName, Object[] params, Class<?>[] paramTypes) {
		super();
		this.interfaceName = interfaceName;
		this.methodName = methodName;
		this.params = params;
		this.paramTypes = paramTypes;
	}

	public String getInterfaceName() {
		return interfaceName;
	}

	public void setInterfaceName(String interfaceName) {
		this.interfaceName = interfaceName;
	}

	public String getMethodName() {
		return methodName;
	}

	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}

	public Object[] getParams() {
		return params;
	}

	public void setParams(Object[] params) {
		this.params = params;
	}

	public Class<?>[] getParamTypes() {
		return paramTypes;
	}

	public void setParamTypes(Class<?>[] paramTypes) {
		this.paramTypes = paramTypes;
	}

}
