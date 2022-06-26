package com.example.forum.dto.postDto;

import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode
public class PostRequestDto {
        private String userName;
        private String title;
        private String descriptionPath;
        private String imagePath;
        private Long categoryId;
}
