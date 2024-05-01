package com.example.JWT.authentication.controller;

import com.example.JWT.authentication.controller.dto.SignUpRequestDto;
import com.example.JWT.authentication.controller.dto.SignUpResponseDto;
import com.example.JWT.authentication.usecase.SignUpUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthenticationController {

    private final SignUpUseCase signUpUseCase;

    @PostMapping("/sing-up")
    public SignUpResponseDto signUp(@RequestBody @Valid SignUpRequestDto dto){

        signUpUseCase.signUp(dto);

        // Service/save()
        return SignUpResponseDto.builder()
                .success(true)
                .message("회원가입을 성공했습니다.")
                .build();
    }
}
