package com.example.threetier.repository;

import com.example.threetier.domain.ReplyVO;
import com.example.threetier.dto.ReplyDTO;
import com.example.threetier.mapper.ReplyMapper;
import com.example.threetier.util.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ReplyDAO {
    private final ReplyMapper replyMapper;

//    추가
    public void save(ReplyVO replyVO){
        replyMapper.insertReply(replyVO);
    }

//    전체 조회
    public List<ReplyDTO> findAll(Long postId, Criteria criteria){
        return replyMapper.selectRepliesByPostId(postId, criteria);
    }

//    개수 조회
    public int findCountAllByPostId(Long postId){
        return replyMapper.selectCountAllByPostId(postId);
    }

//    수정
    public void update(ReplyVO replyVO){
        replyMapper.updateReply(replyVO);
    }

//    삭제
    public void delete(Long id){
        replyMapper.delete(id);
    }
}
