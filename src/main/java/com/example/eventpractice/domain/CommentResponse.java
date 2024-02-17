package com.example.eventpractice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@AllArgsConstructor
public class CommentResponse {
    private Integer id;
    private String title;
    private String contents;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    @Builder
    public CommentResponse(Comment comment){
        this.id = comment.getId();
        this.title = comment.getPost().getAuthor();
        this.contents = comment.getContents();
        this.createdTime = comment.getCreatedTime();
        this.updatedTime = comment.getUpdatedTime();
    }
}
