package com.example.JWT.authentication.mapper;

import com.example.JWT.authentication.controller.dto.SignInResponseDto;
import com.example.JWT.authentication.repository.projection.LoginAccountProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface LoginAccountProjectionMapper {

    SignInResponseDto toDto(LoginAccountProjection projection);

}
