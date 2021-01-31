package com.github.peng49.minirpc.server;

public class TestImpl implements TestInterface {
    @Override
    public void hello() {
        System.out.println("hello rpc!");
    }
}
