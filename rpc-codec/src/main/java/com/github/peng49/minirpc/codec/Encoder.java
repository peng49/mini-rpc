package com.github.peng49.minirpc.codec;

public interface Encoder {
    byte[] encode(Object data);
}
