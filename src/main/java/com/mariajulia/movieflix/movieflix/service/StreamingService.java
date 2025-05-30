package com.mariajulia.movieflix.movieflix.service;

import com.mariajulia.movieflix.movieflix.entity.Streaming;
import com.mariajulia.movieflix.movieflix.repository.StreamingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StreamingService {

    public final StreamingRepository streamingRepository;

    public StreamingService(StreamingRepository streamingRepository) {
        this.streamingRepository = streamingRepository;
    }

    public List<Streaming> findAll() {
        return streamingRepository.findAll();
    }

    public Optional<Streaming> findById(Long id) {
        return streamingRepository.findById(id);
    }
}
