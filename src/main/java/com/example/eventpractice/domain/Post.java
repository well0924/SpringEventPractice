package com.example.eventpractice.domain;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@Table(name = "post")
@ToString
@NoArgsConstructor
public class Post{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(length = 100000,nullable = false)
    private String title;
    @Lob
    private String contents;
    private String author;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

    @OneToMany(mappedBy = "post",fetch = FetchType.LAZY)
    private List<Comment>comments = new ArrayList<>();

    @Builder
    public Post(Integer id,String title,String contents,String author,LocalDateTime createdTime,LocalDateTime updatedTime){
        this.id =id;
        this.title = title;
        this.contents = contents;
        this.author = author;
        this.createdTime = createdTime;
        this.updatedTime = updatedTime;
    }
}
