package com.example.JWT.authentication.service;

import com.example.JWT.authentication.controller.dto.SignUpRequestDto;
import com.example.JWT.authentication.domain.Account;
import com.example.JWT.authentication.domain.types.AccountStatus;
import com.example.JWT.authentication.dto.JwtAuthenticationToken;
import com.example.JWT.authentication.mapper.LoginAccountProjectionMapper;
import com.example.JWT.authentication.mapper.SignUpDtoMapper;
import com.example.JWT.authentication.repository.AccountRepository;
import com.example.JWT.authentication.repository.projection.LoginAccountProjection;
import com.example.JWT.authentication.usecase.SignInUseCase;
import com.example.JWT.authentication.usecase.SignUpUseCase;
import com.example.JWT.common.support.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthenticationService implements SignUpUseCase, SignInUseCase {

    private final AccountRepository accountRepository;
    private final SignUpDtoMapper singUpMapper;
    private final LoginAccountProjectionMapper projectionMapper;
    private final JwtProvider jwtProvider;
    private final PasswordEncoder passwordEncoder;


    @Override
    public Account signUp(Account account) {

        account.password = passwordEncoder.encode(account.password);
        return accountRepository.save(account);
    }

    @Override
    public Account signUp(SignUpRequestDto dto) {

        Account account = singUpMapper.toEntity(dto, AccountStatus.ACTIVE, Instant.now());
        return signUp(account);
    }

    @Override
    public JwtAuthenticationToken signIn(String userEmail, String password) {
        LoginAccountProjection projection = accountRepository
                .findDetailedViewByUserEmail(userEmail)
                .orElseThrow(() -> new RuntimeException("입력을 확인해주세요."));

        boolean isMatched = passwordEncoder.matches(password, projection.password());

        if (!isMatched) {
            throw new RuntimeException("입력을 확인해주세요.");
        }

        Map<String, Object> claims = new HashMap<>();
        claims.put("nickname", projection.nickname());
        claims.put("authority", "USER");

        String accessToken = jwtProvider.generateJwt(userEmail, claims);

        return JwtAuthenticationToken.builder()
                .accessToken(accessToken)
                .refreshToken("...")
                .build();
    }
}