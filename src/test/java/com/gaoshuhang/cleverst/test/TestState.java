package com.gaoshuhang.cleverst.test;

import com.gaoshuhang.cleverst.context.Context;
import com.gaoshuhang.cleverst.context.ContextFactory;
import org.junit.Test;

public class TestState
{
	@Test
	public void test()
	{
		Context<String> context = ContextFactory.createContext("my-context", "com.gaoshuhang.cleverst.test.state");
		context.setCurrentState(context.getStateByStateName("state-a"));
		context.request("A");
		context.request("A");
		context.request("B");
		context.request("ANY");
		context.request("ANY");

		System.out.println("contextName:" + context.getContextName());
		System.out.println("currentState" + context.getCurrentState());

		System.out.println("context:" + ContextFactory.getContextByName("my-context"));
	}
}
