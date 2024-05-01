package com.example.JWT.authentication.usecase;

import com.example.JWT.authentication.controller.dto.SignInRequestDto;
import com.example.JWT.authentication.controller.dto.SignInResponseDto;

public interface SignInUseCase {
    SignInResponseDto signIn(SignInRequestDto dto);
}
