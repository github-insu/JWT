package com.example.JWT.authentication.dto;

import lombok.Builder;

@Builder
public record JwtAuthenticationToken(String accessToken, String refreshToken) {
}
