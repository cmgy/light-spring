package com.cmgy.lightSpring.core.io;

import com.cmgy.lightSpring.util.ClassUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class FileSystemResource implements Resource {

    private String path;

    private ClassLoader classLoader;

    public FileSystemResource(String path) {
        this(path, null);
    }

    public FileSystemResource(String path, ClassLoader classLoader) {
        this.path = path;
        this.classLoader = (classLoader != null ? classLoader : ClassUtils.getDefaultClassLoader());
    }

    public InputStream getInputStream() throws IOException {

        return new FileInputStream(this.path);

    }

    public String getDescription() {

        return "";
    }
}
