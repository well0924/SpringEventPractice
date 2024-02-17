package com.example.eventpractice.repository;

import com.example.eventpractice.domain.Comment;
import com.example.eventpractice.domain.CommentResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Integer> {

    @Query(value = "select c from Comment c where c.post.id = :boardId")
    List<CommentResponse>commentList(Integer boardId);
}
