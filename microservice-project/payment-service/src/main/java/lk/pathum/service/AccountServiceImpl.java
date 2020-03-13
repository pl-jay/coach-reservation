package lk.pathum.service;

import lk.pathum.model.Account;
import lk.pathum.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public class AccountServiceImpl implements AccountService {

    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account save(Account account) {
        return accountRepository.save(account);
    }

    @Override
    public Account fetchAccount(Integer id) {
        Optional<Account> optionalAcc = accountRepository.findById(id);

        if(optionalAcc.isPresent()){
            Account account = optionalAcc.get();
            return account;
        }
        return null;
    }

    @Override
    @Transactional
    public void updateAccount(int by, int to, float amount) {
        accountRepository.updateProviderAccount(by,amount);
        accountRepository.updateConsumerAccount(to,amount);
    }
}
