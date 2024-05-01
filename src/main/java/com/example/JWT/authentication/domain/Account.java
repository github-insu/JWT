package com.example.JWT.authentication.domain;

import com.example.JWT.authentication.domain.types.AccountStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id
    String userEmail;
    String userName;
    String password;
    String nickname;
    @Enumerated(EnumType.STRING)
    AccountStatus status;
    Instant createdAt;
    Instant updatedAt;
}
