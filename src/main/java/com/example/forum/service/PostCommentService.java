package com.example.forum.service;

import com.example.forum.dto.postCommentDto.PostCommentResponseDto;

import java.util.List;

public interface PostCommentService {
    public List<PostCommentResponseDto> getCommentsByPostId(Long id);
}
