package com.mariajulia.movieflix.movieflix.mapper;

import com.mariajulia.movieflix.movieflix.dto.request.StreamingRequest;
import com.mariajulia.movieflix.movieflix.dto.response.StreamingResponse;
import com.mariajulia.movieflix.movieflix.entity.Streaming;
import lombok.experimental.UtilityClass;

@UtilityClass
public class StreamingMapper {

    public static Streaming toStreaming(StreamingRequest streamingRequest) {
        return Streaming.builder()
                .name(streamingRequest.name())
                .build();
    }

    public static StreamingResponse toStreamingResponse(Streaming streaming) {
        return StreamingResponse.builder()
                .id(streaming.getId())
                .name(streaming.getName())
                .build();
    }
}
