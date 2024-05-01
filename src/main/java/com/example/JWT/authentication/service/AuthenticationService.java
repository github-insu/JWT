package com.example.JWT.authentication.service;

import com.example.JWT.authentication.controller.dto.SignUpRequestDto;
import com.example.JWT.authentication.domain.Account;
import com.example.JWT.authentication.domain.types.AccountStatus;
import com.example.JWT.authentication.mapper.SignUpDtoMapper;
import com.example.JWT.authentication.repository.AccountRepository;
import com.example.JWT.authentication.usecase.SignUpUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements SignUpUseCase {

    private final AccountRepository accountRepository;
    private final SignUpDtoMapper mapper;

    @Override
    public Account signUp(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account signUp(SignUpRequestDto dto) {

        Account account = mapper.toEntity(dto, AccountStatus.ACTIVE, Instant.now());
        return signUp(account);
    }
}
