package com.luxoft.logeek.repository.datajpa729;

import com.luxoft.logeek.entity.jira729.BankAccount;
import com.luxoft.logeek.repository.BaseJpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BankAccountRepository extends BaseJpaRepository<BankAccount, Long> {

    /**
     * Bug: unnecessary left outer join
     *
     * @see <a href="https://jira.spring.io/browse/DATAJPA-729">https://jira.spring.io/browse/DATAJPA-729</a>
     */
    long countByUserId(Long id);

    @Query("select count(c.id) from BankAccount c " +
            " where c.user.id = :id")
    long countByUserAccountId(@Param("id") Long id);

    @Query("select count(bac) " +
            "  from BankAccount bac " +
            "  join bac.user user " +
            " where user.id = :id")
    long countUserAccounts(@Param("id") Long id);
}
