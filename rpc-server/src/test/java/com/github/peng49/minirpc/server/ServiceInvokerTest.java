package com.github.peng49.minirpc.server;

import com.github.peng49.minirpc.common.utils.ReflectionUtils;
import com.github.peng49.minirpc.proto.Request;
import com.github.peng49.minirpc.proto.ServiceDescriptor;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Method;

public class ServiceInvokerTest{
    ServiceManager sm;

    @Before
    public void before()
    {
        this.sm = new ServiceManager();

        TestImpl test = new TestImpl();
        sm.register(TestInterface.class,test);
    }

    @Test
    public void invoker()
    {
        Method method = ReflectionUtils.getPublicMethods(TestInterface.class)[0];
        ServiceDescriptor descriptor = ServiceDescriptor.from(TestInterface.class, method);

        Request request = new Request();
        request.setService(descriptor);

        ServiceInstance service = sm.lookup(request);

        ServiceInvoker invoker = new ServiceInvoker();

        Object invoke = invoker.invoke(service,request);
    }
}