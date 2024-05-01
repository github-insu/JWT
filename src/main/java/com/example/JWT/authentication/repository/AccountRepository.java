package com.example.JWT.authentication.repository;

import com.example.JWT.authentication.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
