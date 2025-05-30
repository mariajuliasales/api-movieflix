package com.mariajulia.movieflix.movieflix.service;

import com.mariajulia.movieflix.movieflix.entity.Category;
import com.mariajulia.movieflix.movieflix.repository.CategoryRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    public final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category) {
        return categoryRepository.save(category);
    }
}
