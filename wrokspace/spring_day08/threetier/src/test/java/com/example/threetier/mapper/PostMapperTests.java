package com.example.threetier.mapper;

import com.example.threetier.domain.MemberVO;
import com.example.threetier.dto.MemberDTO;
import com.example.threetier.dto.PostDTO;
import com.example.threetier.util.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
@Slf4j
public class PostMapperTests {
    @Autowired
    private PostMapper postMapper;

    @Test
    public void testSelectAll(){
//        Criteria criteria = new Criteria(1, 128);
//        log.info(criteria.toString());
//        postMapper.selectAll(criteria).stream().map(PostDTO::toString).forEach(log::info);
    }

}



















