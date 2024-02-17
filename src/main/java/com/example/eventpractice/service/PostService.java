package com.example.eventpractice.service;

import com.example.eventpractice.domain.*;
import com.example.eventpractice.event.PostEvent;
import com.example.eventpractice.event.PostListener;
import com.example.eventpractice.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PostService {
    private final PostRepository postRepository;
    private final PostListener postListener;
    private final ApplicationEventPublisher eventPublisher;

    @Transactional(readOnly = true)
    public List<PostResponse>list(){
        List<PostResponse>postResponseList = postRepository.listAll();
        eventPublisher.publishEvent(new PostEvent(this));
        return postResponseList;
    }

    @Transactional
    public PostResponse getPost(Integer id){
        Optional<Post>detail = postRepository.findById(id);
        eventPublisher.publishEvent(new PostEvent(this));
        return PostResponse
                .builder()
                .post(detail.orElseThrow())
                .build();
    }

    @Transactional
    public Integer postCreate(PostRequest postRequest){
        Post post = Post
                .builder()
                .title(postRequest.getTitle())
                .contents(postRequest.getContents())
                .author(postRequest.getAuthor())
                .createdTime(LocalDateTime.now())
                .updatedTime(LocalDateTime.now())
                .build();

        eventPublisher.publishEvent(new PostEvent(this));

        return postRepository.save(post).getId();
    }

    public void deletePost(Integer id){
        postRepository.deleteById(id);
        eventPublisher.publishEvent(new PostEvent(this));
    }
}
