package com.github.peng49.minirpc.codec;

public interface Decoder {
    public <T> T decode(byte[] bytes,Class<T> clazz);
}
