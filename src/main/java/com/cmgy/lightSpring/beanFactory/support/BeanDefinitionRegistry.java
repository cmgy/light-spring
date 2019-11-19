package com.cmgy.lightSpring.beanFactory.support;

import com.cmgy.lightSpring.beanFactory.BeanDefinition;

public interface BeanDefinitionRegistry {

    BeanDefinition getBeanDefinition(String beanName);

    void registerBeanDefinition(String beanId, BeanDefinition beanDefinition);
}
