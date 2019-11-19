package com.cmgy.lightSpring.context.support;

import com.cmgy.lightSpring.beanFactory.support.DefaultBeanFactory;
import com.cmgy.lightSpring.beanFactory.support.XMLBeanDefinitionReader;
import com.cmgy.lightSpring.context.ApplicationContext;
import com.cmgy.lightSpring.core.io.Resource;
import com.cmgy.lightSpring.util.ClassUtils;

public abstract class AbstractApplicationContext implements ApplicationContext {

    protected DefaultBeanFactory defaultBeanFactory;
    protected ClassLoader classLoader;


    public AbstractApplicationContext(String configFile) {

        defaultBeanFactory = new DefaultBeanFactory();
        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(defaultBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(getResourceByPath(configFile));
        defaultBeanFactory.setClassLoader(getClassLoader());

    }

    public Object getBean(String beanName) {
        return defaultBeanFactory.getBean(beanName);
    }


    protected abstract Resource getResourceByPath(String path);

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public ClassLoader getClassLoader() {
        return this.classLoader != null ? this.classLoader : ClassUtils.getDefaultClassLoader();
    }
}
