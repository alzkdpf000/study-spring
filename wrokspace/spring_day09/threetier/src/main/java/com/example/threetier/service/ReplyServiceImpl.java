package com.example.threetier.service;

import com.example.threetier.dto.ReplyCriteriaDTO;
import com.example.threetier.dto.ReplyDTO;
import com.example.threetier.repository.ReplyDAO;
import com.example.threetier.util.Criteria;
import com.example.threetier.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
    private final ReplyDAO replyDAO;

    @Override
    public void write(ReplyDTO replyDTO) {
        replyDAO.save(toReplyVO(replyDTO));
    }

    @Override
    public ReplyCriteriaDTO getReplies(Long postId, int page) {
        ReplyCriteriaDTO replyCriteriaDTO = new ReplyCriteriaDTO();
        Criteria criteria = new Criteria(page, replyDAO.findCountAllByPostId(postId));

        List<ReplyDTO> replies = replyDAO.findAll(postId, criteria);

        replies.forEach((reply) -> {
            reply.setRelativeDate(DateUtils.toRelativeTime(reply.getCreatedDatetime()));
        });

        criteria.setHasMore(replies.size() > criteria.getRowCount());

//        11개 가져왔으면, 마지막 1개 삭제
        if(criteria.isHasMore()){
            replies.remove(replies.size() - 1);
        }

        replyCriteriaDTO.setReplies(replies);
        replyCriteriaDTO.setCriteria(criteria);
        return replyCriteriaDTO;
    }

    @Override
    public void update(ReplyDTO replyDTO) {
        replyDAO.update(toReplyVO(replyDTO));
    }

    @Override
    public void delete(Long id) {
        replyDAO.delete(id);
    }
}
