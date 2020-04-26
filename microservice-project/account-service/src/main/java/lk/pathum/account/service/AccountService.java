package lk.pathum.account.service;

import lk.pathum.account.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<Account> getAll();
    Account save(Account account);
    Account fetchAccount(Integer id);
    boolean updateAccount(int by, int to, float amount);
}
