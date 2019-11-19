package com.cmgy.service.test;

import com.cmgy.lightSpring.core.io.ClassPathResource;
import com.cmgy.lightSpring.core.io.FileSystemResource;
import com.cmgy.lightSpring.core.io.Resource;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class ResourceTest {

    @Test
    public void testClassPahtResource() throws Exception{
        Resource resource = new ClassPathResource("petStore-v1.xml");

        InputStream in = null;

        try{
            in = resource.getInputStream();

            Assert.assertNotNull(in);

        }finally {
            if (null != in) {
                in.close();
            }
        }
    }

    @Test
    public void testFileSystemResource() throws IOException {
        Resource resource = new FileSystemResource("C:\\codeproject\\light-spring\\src\\test\\resources\\petStore-v1.xml");

        InputStream in = null;

        try{
            in = resource.getInputStream();

            Assert.assertNotNull(in);

        }finally {
            if (null != in) {
                in.close();
            }
        }
    }
}
