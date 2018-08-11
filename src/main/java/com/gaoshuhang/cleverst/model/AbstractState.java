package com.gaoshuhang.cleverst.model;

/**
 * 状态抽象类，自定义状态类要继承该类
 * @author gaoshuhang
 * @param <T> 状态转移的消息类型
 */
public abstract class AbstractState<T>
{
	/**
	 * 执行状态转移操作
	 * @param message 消息
	 * @return 注解声明的新状态的名字
	 */
	public abstract String handle(T message);
}
