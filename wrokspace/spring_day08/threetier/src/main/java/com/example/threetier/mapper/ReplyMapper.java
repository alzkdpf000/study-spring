package com.example.threetier.mapper;

import com.example.threetier.domain.ReplyVO;
import com.example.threetier.dto.ReplyDTO;
import com.example.threetier.util.Criteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
//    추가
    public void insertReply(ReplyVO replyVO);

//    전체 조회
    public List<ReplyDTO> selectRepliesByPostId(@Param("postId") Long postId, @Param("criteria") Criteria criteria);
//    개수 조회
    public int selectCountAllByPostId(Long postId);

//    수정
    public void updateReply(ReplyVO replyVO);
    
//    삭제
    public void delete(Long id);
}
