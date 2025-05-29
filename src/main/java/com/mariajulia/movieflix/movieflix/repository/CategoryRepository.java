package com.mariajulia.movieflix.movieflix.repository;

import com.mariajulia.movieflix.movieflix.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
