package com.cmgy.lightSpring.config;

import com.cmgy.lightSpring.exception.BeanCreationException;
import com.cmgy.lightSpring.util.Assert;

import java.util.HashMap;
import java.util.Map;

public class DefaultSingletonBeanRegistry implements SingletonBeanRegistry {

    private Map<String, Object> singletonObjectsMap = new HashMap<>();


    public void registerSingleton(String beanId, Object signletonObject){

        Assert.notNull(beanId, "beanId must not be null");

        Object object = singletonObjectsMap.get(beanId);

        if (object != null) {
            throw new BeanCreationException("bean id=" + beanId + " is singleton,and it has bean registered");
        }

        singletonObjectsMap.put(beanId, signletonObject);
    }

    public Object getSingleton(String beanId){
        return singletonObjectsMap.get(beanId);
    }
}
