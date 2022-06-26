package com.example.forum.service.impl;

import com.example.forum.convertor.PostCommentConvertor;
import com.example.forum.dto.postCommentDto.PostCommentRequestDto;
import com.example.forum.dto.postCommentDto.PostCommentResponseDto;
import com.example.forum.model.PostComment;
import com.example.forum.repository.PostCommentRepository;
import com.example.forum.service.PostCommentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PostCommentServiceImpl implements PostCommentService {
    private final PostCommentRepository postCommentRepository;
    private final PostCommentConvertor postCommentConvertor;

    public PostCommentResponseDto creatComment(PostCommentRequestDto postCommentRequestDto) {
        PostComment postComment = postCommentRepository.save(postCommentConvertor.convertor(postCommentRequestDto));
        return postCommentConvertor.convertor(postComment);
    }

    public  List<PostCommentResponseDto> getCommentsByPostId(Long id) {
        List<PostComment> postComments = postCommentRepository.getPostCommentByPostId(id);
        List<PostCommentResponseDto> postCommentResponseDto=new ArrayList<>();
        for (PostComment postComment : postComments) {
            postCommentResponseDto.add(postCommentConvertor.convertor(postComment));
        }
        return postCommentResponseDto;
    }
}
