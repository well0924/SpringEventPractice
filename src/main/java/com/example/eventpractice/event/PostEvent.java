package com.example.eventpractice.event;

import com.example.eventpractice.domain.Post;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;


@ToString
@Getter
public class PostEvent extends ApplicationEvent {

    private Post post;

    public PostEvent(Object source, Post post) {
        super(source);
        this.post = post;
    }

    public PostEvent(Object source){
        super(source);
    }
}
