package br.com.engineering.worm.repository;

import br.com.engineering.worm.domain.AccountManager;
import br.com.engineering.worm.domain.User;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the AccountManager entity.
 */
@SuppressWarnings("unused")
@Repository
public interface AccountManagerRepository extends JpaRepository<AccountManager, Long>, QuerydslPredicateExecutor<AccountManager> {

}
