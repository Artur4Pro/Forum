package com.example.forum.repository;

import com.example.forum.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository  extends JpaRepository<Category,Long> {
    Category getCategoryById(Long id);
    Category getCategoryByPostCategory(String categoryName);

}
