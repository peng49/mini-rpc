package com.github.peng49.minirpc.example;

public class CalcServiceImpl implements CalcService {
    @Override
    public int sum(int a, int b) {
        return a + b;
    }
}
