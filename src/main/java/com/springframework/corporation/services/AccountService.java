package com.springframework.corporation.services;

import com.springframework.corporation.entities.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAllAccounts();
    Account findById(long id);
    Account addAccount(Account account);
    void deleteAccountById(long id);
}
