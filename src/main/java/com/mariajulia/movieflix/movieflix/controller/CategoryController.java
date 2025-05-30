package com.mariajulia.movieflix.movieflix.controller;

import com.mariajulia.movieflix.movieflix.dto.request.CategoryRequest;
import com.mariajulia.movieflix.movieflix.dto.response.CategoryResponse;
import com.mariajulia.movieflix.movieflix.mapper.CategoryMapper;
import com.mariajulia.movieflix.movieflix.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movieflix/category")
public class CategoryController {

    public final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<CategoryResponse> save(@RequestBody CategoryRequest categoryRequest){
        CategoryResponse newCategory = CategoryMapper.toCategoryResponse(categoryService.save(CategoryMapper.toCategory(categoryRequest)));
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll(){
        List<CategoryResponse> categoryResponse = categoryService.findAll().stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponse);
    }
}
