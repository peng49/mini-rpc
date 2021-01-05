package com.github.peng49.minirpc.example;

public class Client {
    public static void main(String[] args) {
        RpcClient client = new RpcClient();
        CalcService service = client.getProxy(CalcService.class);

        int sum = service.sum(1, 2);

        System.out.println(sum);
    }
}
