package com.gaoshuhang.cleverst.test.state;

import com.gaoshuhang.cleverst.annotation.State;
import com.gaoshuhang.cleverst.model.AbstractState;

@State("state-c")
public class StateC extends AbstractState<String>
{
	@Override
	public String handle(String message)
	{
		System.out.println("C->C");
		return "state-c";
	}
}
