package com.example.eventpractice.repository;

import com.example.eventpractice.domain.Post;
import com.example.eventpractice.domain.PostResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    @Query(value = "select distinct p from Post p left join Comment  c on p.id = c.post.id order by p.id desc ")
    List<PostResponse>listAll();
}
