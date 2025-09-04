package com.example.dependency.injection;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Slf4j
public class CodingTests {
    @Autowired
    private Coding coding;

    @Test
    public void testCoding(){
        log.info("{}", coding);
        assertThat(coding).isNull();
    }

    @Test
    public void testComputer(){
        log.info("{}", coding.getComputer());
        assertThat(coding.getComputer()).isNotNull();
    }
}














