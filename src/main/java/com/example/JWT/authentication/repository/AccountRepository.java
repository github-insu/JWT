package com.example.JWT.authentication.repository;

import com.example.JWT.authentication.domain.Account;
import com.example.JWT.authentication.repository.projection.AccountDetailedViewProjection;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, String> {
    Optional<AccountDetailedViewProjection> findDetailedViewByUserEmail(String userEmail);
}
