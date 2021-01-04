package com.github.peng49.minirpc.codec;

import com.alibaba.fastjson.JSON;

public class JSONEncoder implements Encoder {
    @Override
    public byte[] encode(Object data) {
        return JSON.toJSONBytes(data);
    }
}
