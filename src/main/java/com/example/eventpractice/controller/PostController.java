package com.example.eventpractice.controller;

import com.example.eventpractice.domain.PostRequest;
import com.example.eventpractice.domain.PostResponse;
import com.example.eventpractice.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping("/list")
    public List<PostResponse>list(){
        return postService.list();
    }

    @GetMapping("/{id}")
    public PostResponse getPost(@PathVariable("id")Integer id){
        return postService.getPost(id);
    }

    @PostMapping("/create")
    public Integer postCreate(@RequestBody PostRequest postRequest){
        return postService.postCreate(postRequest);
    }

    @DeleteMapping("/{id}")
    public void postDelete(@PathVariable("id")Integer id){
        postService.deletePost(id);
    }
}
