package com.mariajulia.movieflix.movieflix.mapper;

import com.mariajulia.movieflix.movieflix.dto.request.CategoryRequest;
import com.mariajulia.movieflix.movieflix.dto.response.CategoryResponse;
import com.mariajulia.movieflix.movieflix.entity.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory (CategoryRequest categoryRequest){
        return Category.builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category){
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

}
