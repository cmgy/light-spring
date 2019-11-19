package com.cmgy.service.test;

import com.cmgy.lightSpring.context.ApplicationContext;
import com.cmgy.lightSpring.context.support.ClassPathXmlApplicationContext;
import com.cmgy.lightSpring.context.support.FileSystemXmlApplicationContext;
import com.cmgy.service.PetStoreService;
import org.junit.Assert;
import org.junit.Test;

public class ApplicationContextTest {

    @Test
    public void testGetBeanByClassPathApplicationContext() {
        ApplicationContext context = new ClassPathXmlApplicationContext("petStore-v1.xml");
        PetStoreService petStoreService = (PetStoreService) context.getBean("petstore");
        Assert.assertNotNull(petStoreService);
    }

    @Test
    public void testGetBeanByClassPathApplicationContextV2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("petStore-v1.xml");
        PetStoreService petStoreService = (PetStoreService) context.getBean("petstore");


        Assert.assertNotNull(petStoreService);
    }

    @Test
    public void testGetBeanByFileSystemApplicationContext() {
        ApplicationContext context = new FileSystemXmlApplicationContext("C:\\codeproject\\light-spring\\src\\test\\resources\\petStore-v1.xml");
        PetStoreService petStoreService = (PetStoreService) context.getBean("petstore");
        Assert.assertNotNull(petStoreService);
    }
}
