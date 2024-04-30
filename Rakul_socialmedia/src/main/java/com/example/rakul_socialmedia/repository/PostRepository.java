package com.example.rakul_socialmedia.repository;

import com.example.rakul_socialmedia.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PostRepository extends JpaRepository<Post, Integer> {
    Collection<Object> findAllByUserIdOrderByDateDesc(int id);
}
