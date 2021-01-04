package com.github.peng49.minirpc.codec;

import org.junit.Test;

import static org.junit.Assert.*;

public class JSONDecoderTest {

    @Test
    public void decode() {
        JSONDecoder decoder = new JSONDecoder();
        JSONEncoder encoder = new JSONEncoder();

        TestBean bean = new TestBean();
        bean.setName("123");
        bean.setAge(2);

        byte[] bytes = encoder.encode(bean);

        TestBean bean2 = decoder.decode(bytes, TestBean.class);

        assertEquals(bean.getAge(),bean2.getAge());
        assertEquals(bean.getName(),bean2.getName());


    }
}