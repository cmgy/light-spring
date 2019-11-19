package com.cmgy.service.test;

import com.cmgy.lightSpring.beanFactory.RuntimeBeanReference;
import com.cmgy.lightSpring.beanFactory.TypedStringValue;
import com.cmgy.lightSpring.beanFactory.support.BeanDefinitionResolver;
import com.cmgy.lightSpring.beanFactory.support.DefaultBeanFactory;
import com.cmgy.lightSpring.beanFactory.support.XMLBeanDefinitionReader;
import com.cmgy.lightSpring.core.io.ClassPathResource;
import com.cmgy.service.ChenDao;
import org.junit.Assert;
import org.junit.Test;

public class BeanDefinitionResolverTest {

    @Test
    public void testRuntimeBeanReference() {
        DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();
        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(defaultBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("petStore-v1.xml"));

        BeanDefinitionResolver resolver = new BeanDefinitionResolver(defaultBeanFactory);
        RuntimeBeanReference runtimeBeanReference = new RuntimeBeanReference("chenDao");

        Object o = resolver.resolveIfNeaacesary(runtimeBeanReference);

        Assert.assertNotNull(o);
        Assert.assertTrue(o instanceof ChenDao);

    }


    @Test
    public void testTypedStringValue() {
        DefaultBeanFactory defaultBeanFactory = new DefaultBeanFactory();
        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(defaultBeanFactory);
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("petStore-v1.xml"));

        BeanDefinitionResolver resolver = new BeanDefinitionResolver(defaultBeanFactory);
        TypedStringValue typedStringValue = new TypedStringValue("owner");

        Object o = resolver.resolveIfNeaacesary(typedStringValue);

        Assert.assertNotNull(o);
        Assert.assertEquals("owner", o);

    }
}
