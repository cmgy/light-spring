package com.cmgy.lightSpring.beanFactory.support;

import com.cmgy.lightSpring.beanFactory.BeanDefinition;
import com.cmgy.lightSpring.config.ConfigurableBeanFactory;
import com.cmgy.lightSpring.config.DefaultSingletonBeanRegistry;
import com.cmgy.lightSpring.exception.BeanCreationException;
import com.cmgy.lightSpring.util.Assert;
import com.cmgy.lightSpring.util.ClassUtils;

import java.util.HashMap;
import java.util.Map;

public class DefaultBeanFactory extends DefaultSingletonBeanRegistry
        implements ConfigurableBeanFactory, BeanDefinitionRegistry {

    private Map<String, BeanDefinition> beanDefinitionMap = new HashMap<String, BeanDefinition>();
    private ClassLoader classLoader;

    public DefaultBeanFactory() {
    }

    public void registerBeanDefinition(String beanId, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanId, beanDefinition);
    }


    public BeanDefinition getBeanDefinition(String id) {

        return beanDefinitionMap.get(id);
    }

    public Object getBean(String id) {
        BeanDefinition beanDefinition = beanDefinitionMap.get(id);

        if (null == beanDefinition) {
            throw new BeanCreationException("Bean Definition does not exist");
        }

        if (beanDefinition.isSigleton()) {
            Object bean = getSingleton(id);

            if (bean == null) {
                bean = createBean(beanDefinition);
                registerSingleton(id, bean);
                return bean;
            }
        }

        return createBean( beanDefinition);
    }

    /**
     *
     *
     * @description: 
     * @param beanDefinition
     * @return: 
     * @author: Andy
     * @time: 2019/11/18 15:54
     */  
    private Object createBean(BeanDefinition beanDefinition) {

        Object bean = initBean( beanDefinition);

        putProperty(beanDefinition, bean);

        return bean;
    }

    /**
     *
     *
     * @description: 
     * @param null
     * @return: 
     * @author: Andy
     * @time: 2019/11/18 15:54
     */  
    private Object initBean(BeanDefinition beanDefinition) {

        Assert.notNull(beanDefinition, "beanDefinition has not be null");

        Object o = null;

        String className = beanDefinition.getClassName();

        try {
            o = Class.forName(className).newInstance();

        } catch (Exception e) {
            throw new BeanCreationException("create bean for " + className + " fail.", e);
        }

        return o;

    }

    /**
     *
     *
     * @description: 
     * @param null
     * @return: 
     * @author: Andy
     * @time: 2019/11/18 16:03
     */  
    private void putProperty(BeanDefinition beanDefinition, Object bean) {

    }
    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public ClassLoader getClassLoader() {
        return this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader();
    }
}
