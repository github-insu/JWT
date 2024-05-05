package com.example.JWT.authentication.controller;

import com.example.JWT.authentication.controller.dto.SignInRequestDto;
import com.example.JWT.authentication.controller.dto.SignInResponseDto;
import com.example.JWT.authentication.controller.dto.SignUpRequestDto;
import com.example.JWT.authentication.controller.dto.SignUpResponseDto;
import com.example.JWT.authentication.dto.JwtAuthenticationToken;
import com.example.JWT.authentication.usecase.SignInUseCase;
import com.example.JWT.authentication.usecase.SignUpUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final SignUpUseCase signUpUseCase;
    private final SignInUseCase signInUseCase;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public SignUpResponseDto signUp(@RequestBody @Valid SignUpRequestDto dto){

        signUpUseCase.signUp(dto);

        // Service/save()
        return SignUpResponseDto.builder()
                .success(true)
                .message("회원가입을 성공했습니다.")
                .build();
    }

    @PostMapping("/sign-in")
    public SignInResponseDto singIn(@RequestBody @Valid SignInRequestDto dto){
        JwtAuthenticationToken tokens = signInUseCase.signIn(dto.userEmail(), dto.password());

        return SignInResponseDto.builder()
                .accessToken(tokens.accessToken())
                .build();
    }
}
