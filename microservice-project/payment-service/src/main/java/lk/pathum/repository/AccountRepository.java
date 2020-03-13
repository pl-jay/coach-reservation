package lk.pathum.repository;

import lk.pathum.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface AccountRepository extends JpaRepository<Account, Integer> {

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Account a SET a.balance = a.balance - :amount where a.id = :by") // minimum balance is 100
    void updateProviderAccount(@Param("by") int by, @Param("amount") float amount);

    @Modifying(clearAutomatically = true)
    @Query("UPDATE Account a SET a.balance = a.balance + :amount where a.id = :to") // minimum balance is 100
    void updateConsumerAccount(@Param("to") int to, @Param("amount") float amount);


}

