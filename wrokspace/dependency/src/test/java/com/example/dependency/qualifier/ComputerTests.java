package com.example.dependency.qualifier;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ComputerTests {
    @Autowired
//    @Qualifier("desktop")
    private Computer desktop;

    @Autowired
    @Qualifier("laptop")
    private Computer laptop;

    @Test
    public void testDesktop() {
        log.info("desktop: {}", desktop);
        Assertions.assertThat(desktop).isNotNull();
    }

    @Test
    public void testLaptop() {
        log.info("laptop: {}", laptop);
        Assertions.assertThat(laptop).isNotNull();
    }

}











