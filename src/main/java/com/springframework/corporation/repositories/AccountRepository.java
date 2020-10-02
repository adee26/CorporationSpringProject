package com.springframework.corporation.repositories;

import com.springframework.corporation.entities.Account;
import com.springframework.corporation.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findById(long id);
}
