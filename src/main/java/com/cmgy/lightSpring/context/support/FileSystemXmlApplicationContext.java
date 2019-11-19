package com.cmgy.lightSpring.context.support;

import com.cmgy.lightSpring.core.io.FileSystemResource;
import com.cmgy.lightSpring.core.io.Resource;

public class FileSystemXmlApplicationContext extends AbstractApplicationContext {


    public FileSystemXmlApplicationContext(String path) {

        super(path);
    }

    public Resource getResourceByPath(String path) {
        return new FileSystemResource(path);
    }
}
