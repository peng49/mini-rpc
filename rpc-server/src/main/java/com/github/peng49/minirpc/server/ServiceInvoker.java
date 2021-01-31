package com.github.peng49.minirpc.server;

import com.github.peng49.minirpc.common.utils.ReflectionUtils;
import com.github.peng49.minirpc.proto.Request;

/**
 *  */
public class ServiceInvoker {
    public Object invoke(ServiceInstance instance, Request request) {
        return ReflectionUtils.invoke(
                instance.getTarget(),
                instance.getMethod(),
                request.getParameters()
        );
    }
}
