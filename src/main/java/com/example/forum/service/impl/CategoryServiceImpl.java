package com.example.forum.service.impl;

import com.example.forum.convertor.CategoryConvertor;
import com.example.forum.dto.categoryDto.CategoryRequestDto;
import com.example.forum.dto.categoryDto.CategoryResponseDto;
import com.example.forum.model.Category;
import com.example.forum.repository.CategoryRepository;
import com.example.forum.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final CategoryConvertor categoryConvertor;

    public Category categoryGetById(Long id) {
        return categoryRepository.getCategoryById(id);

    }

    public CategoryResponseDto createCategory(CategoryRequestDto categoryRequestDto) {
        Category category;
        CategoryResponseDto categoryResponseDto = null;
        if (categoryRepository.getCategoryByPostCategory(categoryRequestDto.getPostCategoryType()) == null) {

            category = categoryConvertor.convert(categoryRequestDto);
            categoryRepository.save(category);
            category=categoryRepository.getCategoryByPostCategory(categoryRequestDto.getPostCategoryType());
            categoryResponseDto = categoryConvertor.convert(category);

        } else {
            categoryResponseDto.setErrorText("Duplicate Category");
        }

        return categoryResponseDto;
    }


    public List<CategoryResponseDto> getAllCategory() {
        List<Category> category = categoryRepository.findAll();
        List<CategoryResponseDto> categoryResponseDto = new ArrayList<>();

        for (Category category1 : category) {
            categoryResponseDto.add(categoryConvertor.convert(category1));
        }
        return categoryResponseDto;
    }

    public CategoryResponseDto getByName(String categoryName) {

        return categoryConvertor.convert(categoryRepository.getCategoryByPostCategory(categoryName));
    }

}
