package com.cmgy.lightSpring.beanFactory.support;

import com.cmgy.lightSpring.beanFactory.BeanFactory;
import com.cmgy.lightSpring.beanFactory.RuntimeBeanReference;
import com.cmgy.lightSpring.beanFactory.TypedStringValue;

public class BeanDefinitionResolver {

    private BeanFactory beanFactory;

    public BeanDefinitionResolver(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    public Object resolveIfNeaacesary(Object objcet) {

        if (objcet instanceof RuntimeBeanReference) {
            String beanId = ((RuntimeBeanReference) objcet).getName();
            return beanFactory.getBean(beanId);

        } else if (objcet instanceof TypedStringValue) {

            return ((TypedStringValue) objcet).getValue();
        } else {
            // TODO: 2019/11/18
            throw new RuntimeException("the value " + objcet + " has not implemented");
        }

    }
}
