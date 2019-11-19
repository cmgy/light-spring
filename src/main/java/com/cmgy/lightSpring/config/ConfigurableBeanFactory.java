package com.cmgy.lightSpring.config;

import com.cmgy.lightSpring.beanFactory.BeanFactory;

public interface ConfigurableBeanFactory extends BeanFactory {

    void setClassLoader(ClassLoader classLoader);

    ClassLoader getClassLoader();
}
