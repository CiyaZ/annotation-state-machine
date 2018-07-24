package com.gaoshuhang.sm.model;

import com.gaoshuhang.sm.context.Context;

public abstract class AbstractState<T>
{
	public abstract String handle(T message);
}
