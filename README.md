# 注解配置状态机框架

`CleverState`是一个用注解配置的工作状态控制框架，用于实现桌面程序、安卓程序、微信公众号等web应用工作流，以及游戏AI等。 

## demo

com.example.Main

```java
package com.example;

import Context;
import ContextFactory;

public class Main
{
	public static void main(String[] args)
	{
		//create a context instance
		Context<String> context = ContextFactory.createContext("my-context", "com.example.states");
		//set start state name of context
		context.setCurrentState(context.getStateByStateName("state-a"));
		//send message to state machine
		context.request("A");
		context.request("A");
		context.request("B");
		context.request("ANY");
		context.request("ANY");
		//get current state
		System.out.println("currentState" + context.getCurrentState());
	}
}
```

com.example.states.StateA

```java
package com.example.states;

import State;
import AbstractState;

@State(stateName = "state-a")//this annotation defines state name
public class StateA extends AbstractState<String>//all message type should be the same in a context
{
	@Override
	public String handle(String message)
	{
		//process message
		if(message.equals("A"))
		{
			System.out.println("A->A");
			//state transition
			return "state-a";
		}
		else
		{
			System.out.println("A->B");
			return "state-b";
		}
	}
}
```

com.example.states.StateB

```java
package com.example.states;

import State;
import AbstractState;

@State(stateName = "state-b")
public class StateB extends AbstractState<String>
{
	@Override
	public String handle(String message)
	{
		System.out.println("B->C");
		return "state-c";
	}
}
```

com.example.states.StateC

```java
package com.example.states;

import State;
import AbstractState;

@State(stateName = "state-c")
public class StateC extends AbstractState<String>
{
	@Override
	public String handle(String message)
	{
		System.out.println("C->C");
		return "state-c";
	}
}
```

## 构建

```shell
mvn package
```

