package com.example.JWT.authentication.repository.projection;

import lombok.Builder;

@Builder
public record LoginAccountProjection(
        String userEmail,
        String password,
        String nickname
) {
}
