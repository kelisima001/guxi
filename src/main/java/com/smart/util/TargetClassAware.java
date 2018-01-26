package com.smart.util;

/**
 * 获得目标类（用于Aop Proxy）。
 * 
 * @author Sunxin
 */
public interface TargetClassAware {
	Class<?> getTargetClass();
}
