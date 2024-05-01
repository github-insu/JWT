package com.example.JWT.authentication.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Builder;
import lombok.ToString;

@Builder
public record SignInResponseDto(
        @JsonInclude(Include.NON_EMPTY)
        String userEmail,
        @JsonInclude(Include.NON_EMPTY)
        String nickname,
        @JsonInclude(Include.NON_EMPTY)
        String message
) {
}
