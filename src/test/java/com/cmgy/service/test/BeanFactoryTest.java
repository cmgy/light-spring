package com.cmgy.service.test;

import com.cmgy.lightSpring.beanFactory.BeanDefinition;
import com.cmgy.lightSpring.beanFactory.support.DefaultBeanFactory;
import com.cmgy.lightSpring.beanFactory.support.XMLBeanDefinitionReader;
import com.cmgy.lightSpring.core.io.ClassPathResource;
import com.cmgy.lightSpring.core.io.FileSystemResource;
import com.cmgy.lightSpring.exception.BeanCreationException;
import com.cmgy.lightSpring.exception.BeanDefinitionStoreException;
import com.cmgy.service.PetSellService;
import com.cmgy.service.PetStoreService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BeanFactoryTest {

    private DefaultBeanFactory beanFactory;

    private XMLBeanDefinitionReader xmlBeanDefinitionReader;

    @Before
    public void setup() {
        beanFactory = new DefaultBeanFactory();
        xmlBeanDefinitionReader = new XMLBeanDefinitionReader(beanFactory);

    }

    @Test
    public void testGetBean() {

//        xmlBeanDefinitionReader.loadBeanDefinitions(new FileSystemResource("C:\\codeproject\\light-spring\\src\\test\\resources\\petStore-v1.xml"));
        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("petStore-v1.xml"));

        BeanDefinition beanDefenition = beanFactory.getBeanDefinition("petstore");
        Assert.assertEquals("com.cmgy.service.PetStoreService",beanDefenition.getClassName());

        Assert.assertTrue(beanDefenition.isSigleton());
        Assert.assertFalse(beanDefenition.isPrototype());
        Assert.assertEquals(BeanDefinition.SCOPE_DEFAULT,beanDefenition.getScope());

        PetStoreService petStoreService = (PetStoreService) beanFactory.getBean("petstore");
        Assert.assertNotNull(petStoreService);




    }
    @Test
    public void testGetBean02() {

        xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("petStore-v1.xml"));

        BeanDefinition beanDefenitio2 = beanFactory.getBeanDefinition("petSellService");
        Assert.assertEquals("com.cmgy.service.PetSellService",beanDefenitio2.getClassName());

        Assert.assertFalse(beanDefenitio2.isSigleton());
        Assert.assertTrue(beanDefenitio2.isPrototype());
        Assert.assertEquals(BeanDefinition.SCOPE_PROTOTYPE,beanDefenitio2.getScope());

        PetSellService petSellService = (PetSellService) beanFactory.getBean("petSellService");
        Assert.assertNotNull(petSellService);


    }



    @Test
    public void testInvalidBean() {

        try {
            beanFactory.getBean("invalidBean");
        } catch (BeanCreationException e) {
            return;
        }

        Assert.fail("expect BeanCreationException");

    }

    @Test
    public void testInvalidFile() {

        try {
            xmlBeanDefinitionReader.loadBeanDefinitions(new ClassPathResource("petStore-v1111.xml"));

        } catch (BeanDefinitionStoreException e) {
            return;
        }

        Assert.fail("expect BeanDefinitionStoreException");

    }
}
