package com.kenshoo.kamazon;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HashUtilsTest {

    private String url = ""; //fill this if needed

    @Test
    public void test() throws Exception {
        HashUtils hashUtils = new HashUtils();
        String encrypt = hashUtils.encrypt(url);
        assertEquals(url, hashUtils.decrypt(encrypt));

    }


}