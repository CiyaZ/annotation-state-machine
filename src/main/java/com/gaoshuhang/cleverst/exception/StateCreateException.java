package com.gaoshuhang.cleverst.exception;

/**
 * 状态创建异常
 */
public class StateCreateException extends RuntimeException
{
	/**
	 * 实例化状态创建异常对象
	 */
	public StateCreateException()
	{
		super();
	}

	/**
	 * 实例化状态创建异常对象
	 * @param message 异常消息
	 */
	public StateCreateException(String message)
	{
		super(message);
	}
}
