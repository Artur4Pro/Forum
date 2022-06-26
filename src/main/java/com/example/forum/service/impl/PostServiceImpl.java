package com.example.forum.service.impl;

import com.example.forum.convertor.PostConvertor;
import com.example.forum.dto.postDto.PostRequestDto;
import com.example.forum.dto.postDto.PostResponseDto;
import com.example.forum.dto.postDto.PostUpdateRequestDto;
import com.example.forum.dto.postDto.PostUpdateResponseDto;
import com.example.forum.enams.PostState;
import com.example.forum.model.Category;
import com.example.forum.model.Post;
import com.example.forum.model.User;
import com.example.forum.repository.CategoryRepository;
import com.example.forum.repository.PostRepository;
import com.example.forum.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class PostServiceImpl {
    private final PostRepository postRepository;
    private final PostConvertor postConvertor;
    private final UserRepository userRepository;
    private final CategoryRepository categoryRepository;

    public PostResponseDto creatPost(PostRequestDto postRequestDto) {
        Post post = postConvertor.convertor(postRequestDto);
        return postConvertor.convertor(postRepository.save(post));
    }

    public List<PostResponseDto> getAllPostsByPostStatus(PostState postState, Long id) {
        List<Post> posts = new ArrayList<>();
        List<PostResponseDto> postResponseDto = new ArrayList<>();
        if (id == null) {
            posts = postRepository.getAllByPostState(postState);
            for (Post post : posts) {
                postResponseDto.add(postConvertor.convertor(post));
            }
            return postResponseDto;
        }
        posts.add(postRepository.getPostById(id));
        postResponseDto.add(postConvertor.convertor(posts.get(0)));
        return postResponseDto;
    }

    public List<PostResponseDto> getPostsByUserName(String userName) {

        List<Post> posts = postRepository.getPostByUserUserName(userName);
        List<PostResponseDto> postResponseDto = new ArrayList<>();
        for (Post post : posts) {
            postResponseDto.add(postConvertor.convertor(post));
        }
        return postResponseDto;
    }

    public Post getPostById(Long id) {
        return postRepository.getPostById(id);
    }


    public PostUpdateResponseDto updatePostStatus(PostUpdateRequestDto userUpdateRequestDto, PostState postState) {
        PostUpdateResponseDto postUpdateResponseDto = new PostUpdateResponseDto();
        User admin = userRepository.getUserByUserName(userUpdateRequestDto.getUserName());
        Post post = postRepository.getPostById(userUpdateRequestDto.getId());
        if (admin == null) {
            postUpdateResponseDto.setError("User not found");
            return postUpdateResponseDto;
        }
        if (post == null) {
            postUpdateResponseDto.setError("Post not found");
            return postUpdateResponseDto;
        }

        post.setPostState(postState);
        postRepository.save(post);
        return postUpdateResponseDto;
    }


    public List<PostResponseDto> getAllCreatedPostsBySearch(Long categoryId, String title) {
        List<Post> posts = new ArrayList<>();
        List<PostResponseDto> postResponseDto = new ArrayList<>();
        Category category = categoryRepository.getCategoryById(categoryId);
        if (categoryId == 0) {
            if (title != null) {
                posts = postRepository.getPostByTitleContains(title);
                for (Post post : posts) {
                    if(post.getPostState()==PostState.Created) {
                        postResponseDto.add(postConvertor.convertor(post));
                    }
                }
                return postResponseDto;
            }
            return postResponseDto;
        }
        if (title == null) {
            posts = postRepository.getAllByPostState(PostState.Created);
            for (Post post : posts) {
                if (post.getCategory() == category) {
                    postResponseDto.add(postConvertor.convertor(post));
                }
            }
            return postResponseDto;
        }
        posts = postRepository.getPostByTitleContains(title);
        for (Post post : posts) {
            if(post.getPostState()==PostState.Created) {
                postResponseDto.add(postConvertor.convertor(post));
            }
        }
        postResponseDto.removeIf(responseDto -> categoryRepository.getCategoryByPostCategory(responseDto.getCategory()) != category);
        return postResponseDto;

    }
}
