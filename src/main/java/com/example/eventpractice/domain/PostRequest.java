package com.example.eventpractice.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@AllArgsConstructor
public class PostRequest {
    private String title;
    private String author;
    private String contents;
}
