package com.cmgy.lightSpring.config;

public interface SingletonBeanRegistry {

    void registerSingleton(String beanId, Object signletonObject);

    Object getSingleton(String beanId);
}
