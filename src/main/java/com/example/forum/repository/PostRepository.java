package com.example.forum.repository;

import com.example.forum.enams.PostState;
import com.example.forum.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository  extends JpaRepository<Post,Long> {
    Post getPostById(Long id);
    Post getPostByUserId(Long id);
    List<Post> getAllByPostState(PostState postState);
    List<Post> getAllByUserId(Long id);
    List<Post> getPostByUserUserName(String name);
    List<Post> getPostByTitleContains(String title);
}
