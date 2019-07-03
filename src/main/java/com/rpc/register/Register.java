package com.rpc.register;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import com.rpc.framework.Url;

/**
 * 注册中心 { 服务名 ： {url(注册地址信息) : 具体实现类} 内存隔离导致map 取不到，故存放到文件中
 * 
 * @author z
 *
 */
public class Register {

	private static Map<String, Map<Url, Class<?>>> serviceList = new HashMap<String, Map<Url, Class<?>>>();
	private static String DEFAULT_FILEPATH = "‪D:\register.txt";
	private static Map<Url, Class<?>> urlMap;

	/**
	 * 注册服务
	 * 
	 * @param Url
     *            目标地址 目标端口
	 * @param serviceName
	 *            服务注册名称
	 * @param interfaceImpl
	 *            服务实现类
	 */
	public static void RegisterService(Url url, String serviceName, Class<?> interfaceImpl) {
		urlMap = serviceList.get(serviceName);
		if (null == urlMap || urlMap.isEmpty()) {
			urlMap = new HashMap<Url, Class<?>>();
		}

		urlMap.put(url, interfaceImpl);
		serviceList.put(serviceName, urlMap);

		saveFile();
	}

	/**
	 * 获取实现类
	 * @param serviceName 服务名称
	 * @param url 注册地址
	 * @return
	 */
	public static Class<?> getServiceImplClass(String serviceName, Url url) {
		return serviceList.get(serviceName).get(url);
	}

	/**
	 * 获取注册地址
	 * @param serviceName 服务名称
	 * @return 
	 */
	public static Url getServiceUrl(String serviceName) {
		getFile();
		return serviceList.get(serviceName).keySet().iterator().next();
	}

	/**
	 * 保存文件到本机
	 */
	@SuppressWarnings("resource")
	public static void saveFile() {
		try {
			ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(DEFAULT_FILEPATH));
			file.writeObject(serviceList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 获取文件内容更新map
	 */
	@SuppressWarnings("all")
	public static void getFile() {
		try {
			ObjectInputStream file = new ObjectInputStream(new FileInputStream(DEFAULT_FILEPATH));
			serviceList = (Map<String, Map<Url, Class<?>>>) file.readObject();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
