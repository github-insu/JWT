package com.example.JWT.authentication.controller;

import com.example.JWT.authentication.controller.dto.SignInRequestDto;
import com.example.JWT.authentication.controller.dto.SignInResponseDto;
import com.example.JWT.authentication.controller.dto.SignUpRequestDto;
import com.example.JWT.authentication.controller.dto.SignUpResponseDto;
import com.example.JWT.authentication.usecase.SignInUseCase;
import com.example.JWT.authentication.usecase.SignUpUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final SignUpUseCase signUpUseCase;
    private final SignInUseCase signInUseCase;

    @PostMapping("/sign-up")
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

        return signInUseCase.signIn(dto);
    }
}
