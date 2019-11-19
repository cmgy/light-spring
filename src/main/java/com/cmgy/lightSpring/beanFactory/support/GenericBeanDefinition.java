package com.cmgy.lightSpring.beanFactory.support;

import com.cmgy.lightSpring.beanFactory.BeanDefinition;
import com.cmgy.lightSpring.beanFactory.PropertyValue;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class GenericBeanDefinition implements BeanDefinition {

    private String id;

    private String className;

    private String scope;

    private List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

    public String getClassName() {
        return className;
    }

    public boolean isSigleton(){
        return StringUtils.equals(getScope() ,SCOPE_SINGLETON);
    }

    public boolean isPrototype(){
        return StringUtils.equals(getScope() ,SCOPE_PROTOTYPE);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public void setClassName(String className) {
        this.className = className;
    }


    public String getScope() {
        return scope!=null?scope:SCOPE_DEFAULT;
    }


    public void setScope(String scope) {
        this.scope = scope;
    }


    public List<PropertyValue> getProvertyValueList(){
        return propertyValueList;
    }

    public void addProertyValue(PropertyValue propertyValue) {
        propertyValueList.add(propertyValue);
    }
}
