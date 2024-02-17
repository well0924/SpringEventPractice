package com.example.eventpractice.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;

@Getter
@Entity
@ToString(exclude = "post")
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String contents;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    @JoinColumn(name="post_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;

    @Builder
    public Comment(Integer id,String title,String contents,Post post,LocalDateTime createdTime,LocalDateTime updatedTime){
        this.id =id;
        this.title = post.getAuthor();
        this.contents = contents;
        this.post = post;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }
}
