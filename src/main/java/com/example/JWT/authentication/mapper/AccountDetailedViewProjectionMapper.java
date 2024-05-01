package com.example.JWT.authentication.mapper;

import com.example.JWT.authentication.controller.dto.SignInResponseDto;
import com.example.JWT.authentication.repository.projection.AccountDetailedViewProjection;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountDetailedViewProjectionMapper {

    SignInResponseDto toDto(AccountDetailedViewProjection projection);

}
