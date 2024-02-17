package com.example.eventpractice.event;

import com.example.eventpractice.domain.Comment;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

@ToString
@Getter
public class CommentEvent extends ApplicationEvent {
    private final Comment comment;

    public CommentEvent(Object source, Comment comment) {
        super(source);
        this.comment = comment;
    }


}
