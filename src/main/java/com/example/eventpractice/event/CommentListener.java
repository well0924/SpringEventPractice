package com.example.eventpractice.event;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class CommentListener{

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handleCommentEvent(CommentEvent event){
        System.out.println(event);
        System.out.println("comment id:::"+event.getComment());
        System.out.println("comment contents:::"+event.getComment().getContents());
    }
}
