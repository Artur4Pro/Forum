package com.example.forum.convertor;

import com.example.forum.dto.categoryDto.CategoryRequestDto;
import com.example.forum.dto.categoryDto.CategoryResponseDto;
import com.example.forum.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConvertor {

    public Category convert(CategoryRequestDto categoryRequestDto){
        return new Category(categoryRequestDto.getPostCategoryType());
    }

    public CategoryResponseDto convert(Category category){
        return new CategoryResponseDto(category.getId(),
                category.getPostCategory(),null);
    }
}
