package com.example.JWT.authentication.controller.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;

@Builder
public record SignInRequestDto(
        @NotBlank(message = "아이디를 입력하세요.")
        @Email
        String userEmail,

        @NotBlank(message = "비밀번호를 입력하세요.")
        @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,100}$",
                message = "비밀번호는 영문, 숫자, 특수문자를 모두 포함하여 8자리 이상 100자리 이하로 입력해주세요.")
        String password
) {
}
