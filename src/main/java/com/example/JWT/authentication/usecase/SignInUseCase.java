package com.example.JWT.authentication.usecase;

import com.example.JWT.authentication.dto.JwtAuthenticationToken;

public interface SignInUseCase {
    JwtAuthenticationToken signIn(String userEmail, String password);
}
