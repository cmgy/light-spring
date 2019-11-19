package com.cmgy.service.test;

import com.cmgy.lightSpring.beanFactory.BeanDefinition;
import com.cmgy.lightSpring.beanFactory.PropertyValue;
import com.cmgy.lightSpring.beanFactory.RuntimeBeanReference;
import com.cmgy.lightSpring.beanFactory.TypedStringValue;
import com.cmgy.lightSpring.beanFactory.support.DefaultBeanFactory;
import com.cmgy.lightSpring.beanFactory.support.XMLBeanDefinitionReader;
import com.cmgy.lightSpring.core.io.ClassPathResource;
import com.cmgy.lightSpring.util.Assert;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

import java.util.List;

public class BeanDefinitionTest {


    @Test
    public void testGetProvertyValue() {
        DefaultBeanFactory beanFactory = new DefaultBeanFactory();
        XMLBeanDefinitionReader xmlBeanDefinitionReader = new XMLBeanDefinitionReader(beanFactory);

        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("petStore-v1.xml"));

        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("petstore");


        List<PropertyValue> propertyValueList = beanDefinition.getProvertyValueList();

        Assert.isTrue(propertyValueList.size() == 3);

        PropertyValue chenDaoPV = getProperty(propertyValueList, "chenDao");
        Assert.notNull(chenDaoPV);
        Assert.isTrue(chenDaoPV.getValue() instanceof RuntimeBeanReference);

        PropertyValue haoDaoPV = getProperty(propertyValueList, "haoDao");
        Assert.notNull(haoDaoPV);
        Assert.isTrue(haoDaoPV.getValue() instanceof RuntimeBeanReference);

        PropertyValue envDaoPV = getProperty(propertyValueList, "owner");
        Assert.notNull(envDaoPV);
        Assert.isTrue(envDaoPV.getValue() instanceof TypedStringValue);

    }


    private PropertyValue getProperty(List<PropertyValue> propertyValueList, String name) {

        for (PropertyValue propertyValue : propertyValueList) {
            if (StringUtils.equals(propertyValue.getName(), name)) {
                return propertyValue;
            }
        }

        return null;
    }
}
