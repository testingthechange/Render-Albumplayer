package com.maven.album;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminAccountService {

    private final List<AdminAccount> accounts = new ArrayList<>();

    public AdminAccountService() {
        // preload some dummy accounts
        accounts.add(new AdminAccount(1L, "Alice", "alice@example.com"));
        accounts.add(new AdminAccount(2L, "Bob", "bob@example.com"));
        accounts.add(new AdminAccount(3L, "Charlie", "charlie@example.com"));
    }

    public List<AdminAccount> getAllAccounts() {
        return accounts;
    }

    public void addAccount(String name, String email) {
        long newId = accounts.size() + 1L;
        accounts.add(new AdminAccount(newId, name, email));
    }
}
