package com.example.JWT.authentication.controller.dto;

import lombok.Builder;

@Builder
public record SignUpResponseDto(
        Boolean success,
        String message

) {
}
