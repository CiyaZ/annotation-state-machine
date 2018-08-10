package com.gaoshuhang.cleverst.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface State
{
	String stateName();
}
