package com.cmgy.lightSpring.core.io;


import com.cmgy.lightSpring.util.Assert;
import com.cmgy.lightSpring.util.ClassUtils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ClassPathResource implements Resource {

    private String path;

    private ClassLoader classLoader;

    public ClassPathResource(String path) {
        this(path, null);
    }

    public ClassPathResource(String path, ClassLoader classLoader) {
        Assert.notNull(path, path + " cannot be null");
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    public InputStream getInputStream() throws IOException {
        InputStream in = classLoader.getResourceAsStream(this.path);

        if (in == null) {
            throw new FileNotFoundException(path + " cannot be opened");
        }
        return in;
    }

    public String getDescription() {

        return "";
    }
}
