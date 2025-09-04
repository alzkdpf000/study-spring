package com.example.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class RestaurantTests {
    @Autowired
    Restaurant outback;

    @Autowired
    @Qualifier("vips")
    Restaurant vips;

    @Test
    public void testOutback(){
        log.info("outback: {}", outback);
        log.info("price: {}", ((Outback) outback).getSteakPrice());
        log.info("salad: {}", outback.isSaladBar());
    }

    @Test
    public void testVips(){
        log.info("vips: {}", vips);
        log.info("price: {}", ((Vips) vips).getStreakPrice());
        log.info("salad: {}", vips.isSaladBar());
    }
}
