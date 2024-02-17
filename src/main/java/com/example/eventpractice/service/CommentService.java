package com.example.eventpractice.service;

import com.example.eventpractice.domain.Comment;
import com.example.eventpractice.domain.CommentRequest;
import com.example.eventpractice.domain.CommentResponse;
import com.example.eventpractice.domain.Post;
import com.example.eventpractice.event.CommentEvent;
import com.example.eventpractice.repository.CommentRepository;
import com.example.eventpractice.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service("commentService")
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Transactional(readOnly = true)
    public List<CommentResponse>commentResponseList(Integer boardId){
        return commentRepository.commentList(boardId);
    }

    @Transactional(readOnly = true)
    public CommentResponse getComment(Integer commentId){
        Optional<Comment>comment = commentRepository.findById(commentId);
        applicationEventPublisher.publishEvent(new CommentEvent(this,comment.get()));
        return CommentResponse.builder()
                .comment(comment.orElseThrow())
                .build();
    }

    @Transactional
    public Integer commentCreate(Integer boardId,CommentRequest commentRequest){
        Optional<Post>post = postRepository.findById(boardId);
        if(post.isPresent()){
            Comment comment = Comment
                    .builder()
                    .title(commentRequest.getTitle())
                    .contents(commentRequest.getContents())
                    .post(post.orElseThrow())
                    .createdTime(LocalDateTime.now())
                    .updatedTime(LocalDateTime.now())
                    .build();
            //이벤트 발행
            applicationEventPublisher.publishEvent(new CommentEvent(this,comment));

            return commentRepository.save(comment).getId();
        }
        return null;
    }
}
