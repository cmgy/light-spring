package com.cmgy.lightSpring.beanFactory;

import java.util.List;

public interface BeanDefinition {

    public static final String SCOPE_SINGLETON = "singleton";
    public static final String SCOPE_PROTOTYPE = "prototype";
    public static final String SCOPE_DEFAULT= "singleton";

    String getScope();

    void setScope(String scope);

    String getClassName();

    boolean isSigleton();
    boolean isPrototype();

    List<PropertyValue> getProvertyValueList();
}
