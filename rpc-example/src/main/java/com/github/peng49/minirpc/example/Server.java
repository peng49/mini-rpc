package com.github.peng49.minirpc.example;

import com.github.peng49.minirpc.server.RpcServer;

public class Server {
    public static void main(String[] args) {
        RpcServer rpcServer = new RpcServer();
        rpcServer.register(CalcService.class,CalcServiceImpl.class);
        rpcServer.start();
    }
}
