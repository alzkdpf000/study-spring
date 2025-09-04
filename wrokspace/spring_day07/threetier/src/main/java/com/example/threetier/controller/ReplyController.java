package com.example.threetier.controller;

import com.example.threetier.dto.ReplyCriteriaDTO;
import com.example.threetier.dto.ReplyDTO;
import com.example.threetier.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/replies/**")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;

//    추가
    @PostMapping("write")
    public ResponseEntity<?> write(@RequestBody ReplyDTO replyDTO){
        replyService.write(replyDTO);
        return ResponseEntity.ok(replyDTO);
    }

//    전체 조회
    @GetMapping("/{page}")
    public ResponseEntity<?> list(@PathVariable int page, Long postId){
        ReplyCriteriaDTO replyCriteriaDTO = replyService.getReplies(postId, page);
        if(replyCriteriaDTO.getReplies().size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(replyCriteriaDTO);
        }
        return ResponseEntity.ok().body(replyCriteriaDTO);
    }
    
//    수정
//    수정 해야하는 개수가 서로 다르면, 많은쪽이 Put, 적은쪽이 Patch
//    수정
//    @PatchMapping("/{id}")
//    public void update(ReplyDTO replyDTO){
//
//    }

//    수정(모르겠으면 Put을 써라)
    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody ReplyDTO replyDTO){
        replyService.update(replyDTO);
        return ResponseEntity.ok(replyDTO);
    }

//    삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        replyService.delete(id);
        return ResponseEntity.ok(id + "번 댓글 삭제");
    }
}
