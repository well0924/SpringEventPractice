package com.example.eventpractice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@AllArgsConstructor
public class PostResponse {
    private Integer id;
    private String title;
    private String contents;
    private String author;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;
    private List<CommentResponse>comments;

    @Builder
    public PostResponse(Post post){
        this.id = post.getId();
        this.title = post.getTitle();
        this.contents = post.getContents();
        this.author = post.getAuthor();
        this.createdTime = post.getCreatedTime();
        this.updatedTime = post.getUpdatedTime();
        this.comments = getComments()!=null? post
                .getComments()
                .stream()
                .map(c ->CommentResponse.builder()
                .comment(c)
                .build())
                .collect(Collectors.toList()): new ArrayList<>();
    }
}
