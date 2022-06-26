package com.example.forum.dto.categoryDto;

import lombok.*;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
@EqualsAndHashCode
public class CategoryResponseDto {
    private Long id;
    private String postCategoryType;
    private String errorText;
}
