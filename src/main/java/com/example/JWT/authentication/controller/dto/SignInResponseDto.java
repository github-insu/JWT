package com.example.JWT.authentication.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.ToString;

@Builder
public record SignInResponseDto(
        @JsonProperty("access_token")
        @JsonInclude(Include.NON_EMPTY)
        String accessToken
) {
}
