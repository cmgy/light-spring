package com.cmgy.lightSpring.context.support;

import com.cmgy.lightSpring.core.io.ClassPathResource;
import com.cmgy.lightSpring.core.io.Resource;

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    public ClassPathXmlApplicationContext(String path) {

        super(path);
    }

    public Resource getResourceByPath(String path) {
        return new ClassPathResource(path,getClassLoader());
    }
}
