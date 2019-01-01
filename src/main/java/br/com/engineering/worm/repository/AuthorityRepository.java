package br.com.engineering.worm.repository;

import br.com.engineering.worm.domain.AccountManager;
import br.com.engineering.worm.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

/**
 * Spring Data JPA repository for the Authority entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String>, QuerydslPredicateExecutor<Authority> {
}
