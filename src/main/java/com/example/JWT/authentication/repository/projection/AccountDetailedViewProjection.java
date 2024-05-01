package com.example.JWT.authentication.repository.projection;

import lombok.Builder;

@Builder
public record AccountDetailedViewProjection(
        String userEmail,
        String nickname
) {
}
