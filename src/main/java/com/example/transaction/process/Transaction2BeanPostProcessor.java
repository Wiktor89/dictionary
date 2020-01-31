package com.example.transaction.process;

import java.lang.reflect.Field;

import com.example.transaction.service.Transactional2;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

@Component
public class Transaction2BeanPostProcessor implements BeanPostProcessor {

	private Boolean firstFlag = true;
	private Boolean secondFlag = true;

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		Field[] declaredFields = bean.getClass().getDeclaredFields();
		for (Field field : declaredFields) {
			Transactional2 annotation = field.getAnnotation(Transactional2.class);
			if (annotation != null) {
				field.setAccessible(true);
				String message = annotation.message();
				ReflectionUtils.setField(field, bean, message);
			}
		}
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		if (secondFlag) {
			System.out.println(3);
			secondFlag = false;
		}
		return bean;
	}
}
