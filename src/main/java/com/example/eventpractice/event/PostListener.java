package com.example.eventpractice.event;

import com.example.eventpractice.repository.CommentRepository;
import com.example.eventpractice.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class PostListener{

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void handlePostEvent(PostEvent postEvent){
        // 여기에서 게시글에 대한 이벤트를 처리 (예: 로깅)
        System.out.println("Event received for post: " + postEvent.getPost());
    }

}
