package com.mariajulia.movieflix.movieflix.repository;

import com.mariajulia.movieflix.movieflix.entity.Streaming;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StreamingRepository extends JpaRepository<Streaming, Long> {
}
