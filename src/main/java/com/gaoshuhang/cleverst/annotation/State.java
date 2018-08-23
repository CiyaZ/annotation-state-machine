package com.gaoshuhang.cleverst.annotation;

import java.lang.annotation.*;

/**
 * 这个注解标注的类是可被状态上下文管理的状态类
 */
@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface State
{
	/**
	 * 状态名
	 */
	String value();
}
