package com.example.rakul_socialmedia.repository;

import com.example.rakul_socialmedia.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
