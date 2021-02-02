package com.github.peng49.minirpc.client;


import java.lang.reflect.Proxy;

public class RpcClient {

    public <T> T getProxy(Class<T> clazz) {
        try {
            return (T) Proxy.newProxyInstance(
                    getClass().getClassLoader(),
                    new Class[]{clazz},
                    (proxy, method, args) -> {
                        return new Object();
                    }
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }
}
