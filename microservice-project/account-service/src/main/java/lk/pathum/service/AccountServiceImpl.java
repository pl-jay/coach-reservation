package lk.pathum.service;

import lk.pathum.model.Account;
import lk.pathum.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Repository;
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
    public boolean updateAccount(int by, int to, float amount) {
        Float prevPBalance = null, prevCBalance = null, newPBalance = null, newCBalance = null;
        boolean flag = false;
        // providers account update
        Account accountProvider = new Account();
        accountProvider.setId(by);
        Example<Account> accountProviderExample = Example.of(accountProvider);
        Optional<Account> optionalProviderAccount = accountRepository.findOne(accountProviderExample);

        if (optionalProviderAccount.isPresent()) {

            Account newAccount = optionalProviderAccount.get();
            prevPBalance = newAccount.getBalance(); // get account balance before update

            if(newAccount.getBalance() > amount) {

                newAccount.setBalance(newAccount.getBalance() - amount);
                accountRepository.save(newAccount);
                newPBalance = newAccount.getBalance();

                Account accountConsumer = new Account();
                accountConsumer.setId(to);
                Example<Account> accountConsumerExample = Example.of(accountConsumer);
                Optional<Account> optionalConsumerAccount = accountRepository.findOne(accountConsumerExample);

                if (optionalConsumerAccount.isPresent()) {

                    Account newCAccount = optionalConsumerAccount.get();
                    prevCBalance = newCAccount.getBalance(); // get account balance before update
                    newCAccount.setBalance(newCAccount.getBalance() + amount);
                    accountRepository.save(newCAccount);
                    newCBalance = newCAccount.getBalance();
                }

                if (!(newCBalance.equals(prevCBalance) && newPBalance.equals(prevPBalance))){
                    flag = true;
                }
            }
        }
        return flag;
    }
}