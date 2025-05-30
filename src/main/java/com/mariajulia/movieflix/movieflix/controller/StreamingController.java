package com.mariajulia.movieflix.movieflix.controller;

import com.mariajulia.movieflix.movieflix.dto.response.StreamingResponse;
import com.mariajulia.movieflix.movieflix.mapper.StreamingMapper;
import com.mariajulia.movieflix.movieflix.service.StreamingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movieflix/streaming")
public class StreamingController {

    public final StreamingService streamingService;

    public StreamingController(StreamingService streamingService) {
        this.streamingService = streamingService;
    }

    @GetMapping
    public ResponseEntity<List<StreamingResponse>> findAll() {
        return ResponseEntity.ok(streamingService.findAll()
                .stream()
                .map(streaming -> StreamingMapper.toStreamingResponse(streaming))
                .toList());
    }
}
