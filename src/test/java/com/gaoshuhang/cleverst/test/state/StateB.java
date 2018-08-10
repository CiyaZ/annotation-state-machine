package com.gaoshuhang.cleverst.test.state;

import com.gaoshuhang.cleverst.annotation.State;
import com.gaoshuhang.cleverst.model.AbstractState;

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
