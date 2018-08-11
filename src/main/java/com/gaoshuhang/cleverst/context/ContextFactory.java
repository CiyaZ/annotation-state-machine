package com.gaoshuhang.cleverst.context;

import java.util.HashMap;
import java.util.Map;

/**
 * 状态管理上下文工厂类
 */
public class ContextFactory
{

	private static Map<String, Context> contextMap = new HashMap<>();

	/**
	 * 创建状态管理上下文
	 * @param contextName 上下文名
	 * @param packageScan 包扫描路径
	 * @param <T> 消息类型
	 * @return 状态管理上下文
	 */
	public static <T> Context<T> createContext(String contextName, String packageScan)
	{
		Context<T> context = new Context<>(contextName, packageScan);
		contextMap.put(contextName, context);
		return context;
	}

	/**
	 * 通过状态管理上下文名获得状态管理上下文
	 * @param contextName 状态管理上下文名
	 * @param <T> 消息类型
	 * @return 状态管理上下文对象
	 */
	public static <T> Context<T> getContextByName(String contextName)
	{
		return (Context<T>)contextMap.get(contextName);
	}
}
