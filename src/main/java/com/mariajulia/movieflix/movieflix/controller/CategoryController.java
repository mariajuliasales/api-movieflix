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
    public ResponseEntity<CategoryResponse> save(@RequestBody CategoryRequest categoryRequest) {
        CategoryResponse newCategory = CategoryMapper.toCategoryResponse(categoryService.save(CategoryMapper.toCategory(categoryRequest)));
        return ResponseEntity.status(HttpStatus.CREATED).body(newCategory);
    }

    @GetMapping
    public ResponseEntity<List<CategoryResponse>> findAll() {
        List<CategoryResponse> categoryResponse = categoryService.findAll().stream()
                .map(CategoryMapper::toCategoryResponse)
                .toList();
        return ResponseEntity.status(HttpStatus.OK).body(categoryResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryResponse> findById(@PathVariable Long id) {
        return categoryService.findById(id)
                .map(category -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(category)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        if (categoryService.findById(id).isPresent()) {
            categoryService.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoryResponse> update(@PathVariable Long id, @RequestBody CategoryRequest categoryRequest) {
        return categoryService.update(id, CategoryMapper.toCategory(categoryRequest))
                .map(updatedCategory -> ResponseEntity.ok(CategoryMapper.toCategoryResponse(updatedCategory)))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }
}
