package com.example.mysql.mapper;

import com.example.mysql.dto.PostMemberDTO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void testSelectById(){
        PostMemberDTO postMemberDTO = postMapper.selectById(1L);
        System.out.println(postMemberDTO);
    }
}
