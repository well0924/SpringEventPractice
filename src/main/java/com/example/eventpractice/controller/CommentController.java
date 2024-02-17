package com.example.eventpractice.controller;

import com.example.eventpractice.domain.CommentRequest;
import com.example.eventpractice.domain.CommentResponse;
import com.example.eventpractice.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;

    @GetMapping("/comment/list/{id}")
    public List<CommentResponse>list(@PathVariable("id") Integer boardId){
        return commentService.commentResponseList(boardId);
    }

    @GetMapping("/comment/{id}")
    public CommentResponse getComment(@PathVariable("id")Integer id){
        return commentService.getComment(id);
    }

    @PostMapping("/comment/create/{id}")
    public Integer commentCreate(@PathVariable("id")Integer boardId,@RequestBody CommentRequest commentRequest){
        return commentService.commentCreate(boardId,commentRequest);
    }
}
