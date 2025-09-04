package com.example.threetier.service;

import com.example.threetier.dto.PostCriteriaDTO;
import com.example.threetier.dto.PostDTO;
import com.example.threetier.repository.PostDAO;
import com.example.threetier.util.Criteria;
import com.example.threetier.util.DateUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostDAO postDAO;

    @Override
    public PostCriteriaDTO getList(int page) {
        PostCriteriaDTO postCriteriaDTO = new PostCriteriaDTO();
        Criteria criteria = new Criteria(page, postDAO.findCountAll());
        List<PostDTO> posts = postDAO.findAll(criteria);
        posts.forEach((post) -> {
            post.setRelativeDate(DateUtils.toRelativeTime(post.getCreatedDatetime()));
        });

        criteria.setHasMore(posts.size() > criteria.getRowCount());

//        11개 가져왔으면, 마지막 1개 삭제
        if(criteria.isHasMore()){
            posts.remove(posts.size() - 1);
        }

        postCriteriaDTO.setPosts(posts);
        postCriteriaDTO.setCriteria(criteria);
        return postCriteriaDTO;
    }
}










