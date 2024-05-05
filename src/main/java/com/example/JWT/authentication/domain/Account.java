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
    public String userEmail;
    public String userName;
    public String password;
    public String nickname;
    @Enumerated(EnumType.STRING)
    public AccountStatus status;
    public Instant createdAt;
    public Instant updatedAt;
}
