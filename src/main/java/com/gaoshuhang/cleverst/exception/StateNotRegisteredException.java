package com.gaoshuhang.cleverst.exception;

/**
 * 状态未注册异常，即状态转移的目标状态不存在
 */
public class StateNotRegisteredException extends RuntimeException
{
	/**
	 * 实例化状态未注册异常
	 */
	public StateNotRegisteredException()
	{
		super();
	}

	/**
	 * 实例化状态未注册异常
	 * @param message 异常消息
	 */
	public StateNotRegisteredException(String message)
	{
		super(message);
	}
}
