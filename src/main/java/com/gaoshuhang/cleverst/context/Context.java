package com.gaoshuhang.cleverst.context;

import com.gaoshuhang.cleverst.annotation.State;
import com.gaoshuhang.cleverst.exception.StateCreateException;
import com.gaoshuhang.cleverst.exception.StateNotRegisteredException;
import com.gaoshuhang.cleverst.model.AbstractState;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 状态管理上下文
 * @param <T> 状态转移的消息类型
 */
public class Context<T>
{
	private String contextName;
	private Map<String, AbstractState<T>> abstractStateMap = new HashMap<>();

	private AbstractState<T> currentState;

	protected Context(String contextName, String packageScan)
	{
		this.contextName = contextName;

		Reflections reflections = new Reflections(packageScan);
		Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(State.class);
		for(Class<?> stateClass : annotated)
		{
			State stateAnnotation = stateClass.getAnnotation(State.class);
			String stateName = stateAnnotation.stateName();

			try
			{
				abstractStateMap.put(stateName, (AbstractState<T>) stateClass.newInstance());
			}
			catch (InstantiationException | IllegalAccessException e)
			{
				e.printStackTrace();
				throw new StateCreateException("状态类实例化失败");
			}
		}
	}

	/**
	 * 获得状态管理上下文的名字
	 * @return 名字字符串
	 */
	public String getContextName()
	{
		return contextName;
	}

	/**
	 * 根据注解定义的状态名返回状态对象
	 * @param stateName 状态名字符串
	 * @return 状态对象
	 */
	public AbstractState<T> getStateByStateName(String stateName)
	{
		return this.abstractStateMap.get(stateName);
	}

	/**
	 * 获得状态管理上下文中当前的状态
	 * @return 装态对象
	 */
	public AbstractState<T> getCurrentState()
	{
		return this.currentState;
	}

	/**
	 * 强行设置当前状态管理上下文的状态
	 * @param currentState 状态对象
	 */
	public void setCurrentState(AbstractState<T> currentState)
	{
		this.currentState = currentState;
	}

	/**
	 * 向状态管理上下文发消息以触发状态转移
	 * @param message 消息对象
	 */
	public void request(T message)
	{
		String resultState = currentState.handle(message);
		AbstractState<T> targetState = abstractStateMap.get(resultState);
		if(targetState == null)
		{
			throw new StateNotRegisteredException("目标状态类未注册到上下文中");
		}
		else
		{
			currentState = targetState;
		}
	}
}
