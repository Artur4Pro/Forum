package com.example.forum.controller;

import com.example.forum.dto.postDto.PostRequestDto;
import com.example.forum.dto.postDto.PostResponseDto;
import com.example.forum.dto.postDto.PostUpdateRequestDto;
import com.example.forum.dto.postDto.PostUpdateResponseDto;
import com.example.forum.enams.PostState;
import com.example.forum.service.impl.PostServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@AllArgsConstructor
public class PostController {

    private final PostServiceImpl postService;


    @PostMapping("/post")
    public PostResponseDto creatPost(@RequestBody PostRequestDto postRequestDto) {
        return postService.creatPost(postRequestDto);
    }

    @GetMapping("/createdPosts")
    public List<PostResponseDto> getAllCreatedPosts() {

        return postService.getAllPostsByPostStatus(PostState.Created, null);
    }


    @GetMapping("/createdPosts/{id}")
    public List<PostResponseDto> getCreatedPostById(@PathVariable("id") Long id) {
        return postService.getAllPostsByPostStatus(PostState.Created, id);
    }


    @PostMapping("/searchPosts")
    public List<PostResponseDto> getAllCreatedPostsByCategory(@RequestBody PostRequestDto postRequestDto) {
        return postService.getAllCreatedPostsBySearch(postRequestDto.getCategoryId(), postRequestDto.getTitle());
    }


    @GetMapping("/waitingPosts")
    public List<PostResponseDto> getAllWaitingPosts() {
        return postService.getAllPostsByPostStatus(PostState.Waiting, null);
    }


    @GetMapping("/getPostsByUserName/{userName}")
    public List<PostResponseDto> getAllWaitingPosts(@PathVariable("userName") String name) {
        return postService.getPostsByUserName(name);
    }

    @PostMapping("/blockPost")

    public PostUpdateResponseDto blockPost(@RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        return postService.updatePostStatus(postUpdateRequestDto, PostState.Blocked);
    }


    @PostMapping("/activatePost")
    public PostUpdateResponseDto activatePost(@RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        return postService.updatePostStatus(postUpdateRequestDto, PostState.Created);
    }


    @PostMapping("/privatePost")
    public PostUpdateResponseDto privatePost(@RequestBody PostUpdateRequestDto postUpdateRequestDto) {
        return postService.updatePostStatus(postUpdateRequestDto, PostState.Private);
    }


}
