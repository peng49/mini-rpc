package com.github.peng49.minirpc.example;

public class Server {
    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServie();
        rpcServer.register(CalcService.class,CalcServiceImpl.class);
        rpcServer.start();
    }
}
