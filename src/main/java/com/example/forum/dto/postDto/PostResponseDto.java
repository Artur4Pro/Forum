package com.example.forum.dto.postDto;

import com.example.forum.dto.postCommentDto.PostCommentResponseDto;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PostResponseDto {
    private Long postId;
    private String title;
    private String descriptionPath;
    private String imagePath;
    private String category;
    private LocalDateTime localDateTime;
    private String status;
    private String firstName;
    private String lastName;
    private List< PostCommentResponseDto> comments;

    public PostResponseDto(Long postId, String title, String descriptionPath, String imagePath, String category, LocalDateTime localDateTime, String status) {
        this.postId = postId;
        this.title = title;
        this.descriptionPath = descriptionPath;
        this.imagePath = imagePath;
        this.category = category;
        this.localDateTime = localDateTime;
        this.status = status;
    }
}
