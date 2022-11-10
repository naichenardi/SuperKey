package com.superkey;

import com.superkey.db.entities.Account;
import com.superkey.db.repositories.AccountRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.List;

@DataJpaTest
class AccountEntityRepositoryTest {
    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private AccountRepository repository;

    private void insertAccounts() {
        entityManager.persist(new Account("Emp1", "repre@Emp1.com", "123321"));
        entityManager.persist(new Account("EMp2", "repre@EMp2.com", "123321"));
        entityManager.persist(new Account("Emp3", "repre@Emp3.com", "123321"));
    }

    @Test
    public void shouldReturnSomeAccounts(){
        insertAccounts();

        Iterable<Account> accounts = repository.findAll();

        List<Account> list = new ArrayList<>();
        accounts.iterator().forEachRemaining(list::add);

        Assertions.assertEquals(list.size(),3);
    }

    @Test
    public void shouldDeleteFirstLine(){
        insertAccounts();

        Account account = repository.findAll().iterator().next();

        Assertions.assertEquals(3,repository.count());

        repository.delete(account);

        Assertions.assertEquals(2,repository.count());
    }
}