package com.example.JWT.authentication.mapper;

import com.example.JWT.authentication.controller.dto.SignUpRequestDto;
import com.example.JWT.authentication.domain.Account;
import com.example.JWT.authentication.domain.types.AccountStatus;
import org.mapstruct.Mapper;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface SignUpDtoMapper {

    Account toEntity(SignUpRequestDto dto, AccountStatus status, Instant createdAt);

}
