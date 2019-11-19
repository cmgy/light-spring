package com.cmgy.lightSpring.beanFactory.support;

import com.cmgy.lightSpring.beanFactory.PropertyValue;
import com.cmgy.lightSpring.beanFactory.RuntimeBeanReference;
import com.cmgy.lightSpring.beanFactory.TypedStringValue;
import com.cmgy.lightSpring.core.io.Resource;
import com.cmgy.lightSpring.exception.BeanDefinitionStoreException;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.util.List;

public class XMLBeanDefinitionReader {

    private static final String ATTRIBUTE_CLASS = "class";
    private static final String ATTRIBUTE_ID = "id";
    private static final String ATTRIBUTE_SCOPE = "scope";
    private static final String ATTRIBUTE_PROPERTY = "property";
    private static final String ATTRIBUTE_PROPERTY_NAME = "name";
    private static final String ATTRIBUTE_PROPERTY_REF = "ref";
    private static final String ATTRIBUTE_PROPERTY_VALUE = "value";
    private static final String ELEMENT_BEANS = "bean";


    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XMLBeanDefinitionReader(BeanDefinitionRegistry beanDefinitionRegistry) {
        this.beanDefinitionRegistry = beanDefinitionRegistry;
    }

    public void loadBeanDefinitions(Resource resource) {

        SAXReader saxReader = new SAXReader();
        Document document = null;
        try {
            document = saxReader.read(resource.getInputStream());

        } catch (DocumentException e) {
            throw new BeanDefinitionStoreException("xml file dose not exist", e);
        } catch (IOException e) {
            throw new BeanDefinitionStoreException("xml file dose not exist", e);
        }

        Element root = document.getRootElement();

        List<Element> elements = root.elements(ELEMENT_BEANS);

        for (Element element : elements) {
            String id = element.attributeValue(ATTRIBUTE_ID);
            String className = element.attributeValue(ATTRIBUTE_CLASS);
            String scope = element.attributeValue(ATTRIBUTE_SCOPE);
            GenericBeanDefinition genericBeanDefinition = new GenericBeanDefinition();
            genericBeanDefinition.setId(id);
            genericBeanDefinition.setClassName(className);
            genericBeanDefinition.setScope(scope);

            List<Element> properts = element.elements(ATTRIBUTE_PROPERTY);

            for (Element proertyElement : properts) {
                genericBeanDefinition.addProertyValue(parsePropertyValue(proertyElement));
            }

            beanDefinitionRegistry.registerBeanDefinition(id, genericBeanDefinition);
        }
    }

    private PropertyValue parsePropertyValue(Element element) {

        PropertyValue propertyValue = new PropertyValue();

        String name = element.attributeValue(ATTRIBUTE_PROPERTY_NAME);

        String ref = element.attributeValue(ATTRIBUTE_PROPERTY_REF);

        String value = element.attributeValue(ATTRIBUTE_PROPERTY_NAME);

        if (ref != null) {

            RuntimeBeanReference runtimeBeanReference = new RuntimeBeanReference(ref);
            propertyValue.setValue(runtimeBeanReference);

        }

        else if (value != null) {
            TypedStringValue typedStringValue = new TypedStringValue(value);
            propertyValue.setValue(typedStringValue);

        }
        else {
            throw new RuntimeException("");
        }

        propertyValue.setName(name);

        return propertyValue;

    }
}
