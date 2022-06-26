package com.example.forum.controller;

import com.example.forum.dto.postCommentDto.PostCommentRequestDto;
import com.example.forum.dto.postCommentDto.PostCommentResponseDto;
import com.example.forum.service.impl.PostCommentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class PostCommentController {
    private final PostCommentServiceImpl postCommentService;


    @PostMapping("/comment")
    public PostCommentResponseDto creatComment(@RequestBody PostCommentRequestDto postCommentRequestDto) {
        return postCommentService.creatComment(postCommentRequestDto);
    }


    @GetMapping("/getComment/{postId}")
    public List<PostCommentResponseDto> getCommentsByPostId(@PathVariable("postId") Long id) {
        return postCommentService.getCommentsByPostId(id);
    }
}
