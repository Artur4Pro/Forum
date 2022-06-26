package com.example.forum.convertor;

import com.example.forum.dto.postCommentDto.PostCommentResponseDto;
import com.example.forum.dto.postDto.PostRequestDto;
import com.example.forum.dto.postDto.PostResponseDto;
import com.example.forum.enams.AnswerState;
import com.example.forum.enams.PostState;
import com.example.forum.model.Post;
import com.example.forum.model.PostComment;
import com.example.forum.repository.CategoryRepository;
import com.example.forum.repository.PostCommentRepository;
import com.example.forum.repository.UserRepository;
import com.example.forum.util.Path;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
@AllArgsConstructor
public class PostConvertor {
    public final UserRepository userRepository;
    private final CategoryRepository categoryRepository;
    private final PostCommentRepository postCommentRepository;
    private final PostCommentConvertor postCommentConvertor;

    public Post convertor(PostRequestDto postRequestDto) {
        Post post = new Post(userRepository.getUserByUserName(postRequestDto.getUserName()),
                postRequestDto.getTitle(),
                Path.savePath(postRequestDto.getDescriptionPath(),
                        userRepository.getUserByUserName(postRequestDto.getUserName())),
                Path.savePath(postRequestDto.getImagePath(),
                        userRepository.getUserByUserName(postRequestDto.getUserName())),
                PostState.Waiting,
                AnswerState.NOT_ANSWERED,
                LocalDateTime.now(),
                0.0,
                0L,
                categoryRepository.getCategoryById(postRequestDto.getCategoryId()));
        System.out.println(post);
        return post;
    }

    public PostResponseDto convertor(Post post) {
        PostResponseDto postResponseDto = new PostResponseDto(
                post.getId(),
                post.getTitle(),
                Path.readPath(post.getDescriptionPath()),
                Path.readPath(post.getImagePath()),
                post.getCategory().getPostCategory(),
                post.getLocalDateTime(),post.getPostState().toString());
        postResponseDto.setFirstName(post.getUser().getFirstName());
        postResponseDto.setLastName(post.getUser().getLastName());
        postResponseDto.setComments(getCommentsByPostId(post.getId()));
        System.out.println(postResponseDto);
        return postResponseDto;
    }
    public List<PostCommentResponseDto> getCommentsByPostId(Long id) {
        List<PostComment> postComments = postCommentRepository.getPostCommentByPostId(id);
        List<PostCommentResponseDto> postCommentResponseDto=new ArrayList<>();
        for (PostComment postComment : postComments) {
            postCommentResponseDto.add(postCommentConvertor.convertor(postComment));
        }
        return postCommentResponseDto;
    }
}
