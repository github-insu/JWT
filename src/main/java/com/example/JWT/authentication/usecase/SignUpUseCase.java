package com.example.JWT.authentication.usecase;

import com.example.JWT.authentication.controller.dto.SignUpRequestDto;
import com.example.JWT.authentication.domain.Account;

public interface SignUpUseCase {
    Account signUp(Account account);
    Account signUp(SignUpRequestDto dto);
}
