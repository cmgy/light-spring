package com.cmgy.service.test.suit;

import com.cmgy.service.test.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({BeanFactoryTest.class, ApplicationContextTest.class, ResourceTest.class, BeanDefinitionTest.class,
        BeanDefinitionResolverTest.class})
public class V1Tests {
}
