package com.mariajulia.movieflix.movieflix.dto.response;

import lombok.Builder;

@Builder
public record StreamingResponse(Long id,
                                String name) {
}
