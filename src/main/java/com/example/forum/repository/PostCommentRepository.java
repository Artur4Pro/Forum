package com.example.forum.repository;

import com.example.forum.model.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostCommentRepository extends JpaRepository<PostComment,Long> {
    List< PostComment > getPostCommentByPostId(Long id);
}
