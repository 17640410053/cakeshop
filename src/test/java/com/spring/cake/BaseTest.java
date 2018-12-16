package com.spring.cake;

import org.junit.Test;

import java.util.UUID;

public class BaseTest {
    @Test
    public void UUIDTest() {
        System.out.println(UUID.randomUUID().toString());
    }
}
