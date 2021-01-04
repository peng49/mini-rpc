package com.github.peng49.minirpc.common.utils;

import org.junit.Test;

import java.lang.reflect.Method;

import static org.junit.Assert.*;

public class ReflectionUtilsTest {

    @Test
    public void newInstance() {
        TestClass instance = ReflectionUtils.newInstance(TestClass.class);
        assertNotNull(instance);
    }

    @Test
    public void getPublicMethods() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        assertEquals(1,methods.length);
        Method method = methods[0];
        assertEquals("b",method.getName());
    }

    @Test
    public void invoke() {
        Method[] methods = ReflectionUtils.getPublicMethods(TestClass.class);
        Method method = methods[0];
        Object invoke = ReflectionUtils.invoke(new TestClass(), method);
        assertEquals("b",invoke);
    }
}