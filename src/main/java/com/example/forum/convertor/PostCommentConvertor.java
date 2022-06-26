package com.example.forum.convertor;


import com.example.forum.dto.postCommentDto.PostCommentRequestDto;
import com.example.forum.dto.postCommentDto.PostCommentResponseDto;
import com.example.forum.model.PostComment;
import com.example.forum.repository.PostRepository;
import com.example.forum.repository.UserRepository;
import com.example.forum.util.Path;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
@AllArgsConstructor
public class PostCommentConvertor {

    public final PostRepository postRepository;
    public final UserRepository userRepository;
    public PostComment convertor(PostCommentRequestDto postCommentRequestDto){
        PostComment postComment=new PostComment();
        postComment.setPost(postRepository.getPostById(postCommentRequestDto.getPostId()));
        postComment.setUser(userRepository.getUserById(postCommentRequestDto.getUserId()));

        postComment.setDescription( Path.savePath(postCommentRequestDto.getComment(),
                userRepository.getUserById(postCommentRequestDto.getUserId())));
        postComment.setCommentDate(LocalDateTime.now());
        return postComment;
    }
    public PostCommentResponseDto convertor(PostComment postComment){
        return new PostCommentResponseDto(postComment.getUser().getFirstName(),
                postComment.getUser().getLastName(),
                Path.readPath(postComment.getDescription()) ,
                postComment.getCommentDate());
    }
}
