package com.example.JWT.authentication.service;

import com.example.JWT.authentication.controller.dto.SignInRequestDto;
import com.example.JWT.authentication.controller.dto.SignInResponseDto;
import com.example.JWT.authentication.controller.dto.SignUpRequestDto;
import com.example.JWT.authentication.domain.Account;
import com.example.JWT.authentication.domain.types.AccountStatus;
import com.example.JWT.authentication.mapper.AccountDetailedViewProjectionMapper;
import com.example.JWT.authentication.mapper.SignUpDtoMapper;
import com.example.JWT.authentication.repository.AccountRepository;
import com.example.JWT.authentication.repository.projection.AccountDetailedViewProjection;
import com.example.JWT.authentication.usecase.SignInUseCase;
import com.example.JWT.authentication.usecase.SignUpUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements SignUpUseCase, SignInUseCase {

    private final AccountRepository accountRepository;
    private final SignUpDtoMapper singUpMapper;
    private final AccountDetailedViewProjectionMapper projectionMapper;

    @Override
    public Account signUp(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account signUp(SignUpRequestDto dto) {

        Account account = singUpMapper.toEntity(dto, AccountStatus.ACTIVE, Instant.now());
        return signUp(account);
    }

    @Override
    public SignInResponseDto signIn(SignInRequestDto dto) {
        AccountDetailedViewProjection projection = accountRepository.findDetailedViewByUserEmail(dto.userEmail())
                .orElseThrow(() -> { throw new IllegalArgumentException("입력을 확인해주세요."); });

        return projectionMapper.toDto(projection);
    }
}
