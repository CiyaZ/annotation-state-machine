package com.gaoshuhang.sm.context;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContextFactory
{

	private static Map<String, Context> contextMap = new HashMap<>();

	public static <T> Context<T> createContext(String contextName, String packageScan)
	{
		Context<T> context = new Context<>(contextName, packageScan);
		contextMap.put(contextName, context);
		return context;
	}

	public static <T> Context<T> getContextByName(String contextName)
	{
		return (Context<T>)contextMap.get(contextName);
	}
}
