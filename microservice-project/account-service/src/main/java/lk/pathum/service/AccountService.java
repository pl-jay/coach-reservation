package lk.pathum.service;

import lk.pathum.model.Account;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<Account> getAll();
    Account save(Account account);
    Account fetchAccount(Integer id);
    boolean updateAccount(int by, int to, float amount);
}
