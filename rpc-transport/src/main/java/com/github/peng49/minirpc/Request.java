package com.github.peng49.minirpc;

import lombok.Data;

@Data
public class Request {
    private ServiceDescriptor service;
    private Object[] parameters;
}
