package com.github.peng49.minirpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

public class JSONEncoderTest {

    @Test
    public void encode() {
        JSONEncoder encoder = new JSONEncoder();
        TestBean bean = new TestBean();
        bean.setAge(1);
        bean.setName("peng49");

        byte[] bytes = encoder.encode(bean);

        assertNotNull(bytes);
    }
}