package com.msk.core.datasource;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
public class DynamicDataSourceAspect implements Ordered{
	@Before("execution(* com.msk.*.logic.*(..))")
	public void setDynamicDataSource(JoinPoint jp) {
		Signature signature = jp.getSignature();
		//获得对象
		Class<?> clazz = signature.getDeclaringType();
		//获得方法名称
		String methodName = signature.getName();
		
		Method[] methodList = clazz.getDeclaredMethods();
		for (Method method : methodList) {
			String declaredMethodName = method.getName();
			//如果方法名称相同
			if(declaredMethodName.equals(methodName)){
				Transactional transactional = method.getAnnotation(Transactional.class);
				if(transactional!=null){
					boolean readOnly = transactional.readOnly();
					//只读方式读取ReadOnlyDataSource
					if(readOnly){
						DatabaseContextHolder.setCustomerType(DatabaseContextHolder.SLAVE_DATA_SOURCE);
					}else{//非只读情况下为BusinessDataSource
						DatabaseContextHolder.setCustomerType(DatabaseContextHolder.MASTER_DATA_SOURCE);
					}
				}else{
						DatabaseContextHolder.setCustomerType(DatabaseContextHolder.SLAVE_DATA_SOURCE);
				}
				break;
			}
		}
	}
	public int getOrder() {
		return 0;
	}
}
