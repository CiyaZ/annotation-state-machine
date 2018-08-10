package com.gaoshuhang.cleverst.model;

public abstract class AbstractState<T>
{
	public abstract String handle(T message);
}
