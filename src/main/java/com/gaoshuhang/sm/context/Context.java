package com.gaoshuhang.sm.context;

import com.gaoshuhang.sm.annotation.State;
import com.gaoshuhang.sm.exception.StateCreateException;
import com.gaoshuhang.sm.exception.StateNotRegisteredException;
import com.gaoshuhang.sm.model.AbstractState;
import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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
				throw new StateCreateException("State class initialize failed.");
			}
		}
	}

	public String getContextName()
	{
		return contextName;
	}

	public AbstractState<T> getStateByStateName(String stateName)
	{
		return this.abstractStateMap.get(stateName);
	}

	public AbstractState<T> getCurrentState()
	{
		return this.currentState;
	}

	public void setCurrentState(AbstractState<T> currentState)
	{
		this.currentState = currentState;
	}

	public void request(T message)
	{
		String resultState = currentState.handle(message);
		AbstractState<T> targetState = abstractStateMap.get(resultState);
		if(targetState == null)
		{
			throw new StateNotRegisteredException("Target state class not registered.");
		}
		else
		{
			currentState = targetState;
		}
	}
}
