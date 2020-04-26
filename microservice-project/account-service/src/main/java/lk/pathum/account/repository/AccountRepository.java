package lk.pathum.account.repository;

import lk.pathum.account.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;


public interface AccountRepository extends JpaRepository<Account, Integer> {
}

