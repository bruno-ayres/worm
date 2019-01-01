package br.com.engineering.worm.repository;

import br.com.engineering.worm.domain.Customer;
import br.com.engineering.worm.domain.OpportunityHistory;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the OpportunityHistory entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OpportunityHistoryRepository extends JpaRepository<OpportunityHistory, Long>, QuerydslPredicateExecutor<OpportunityHistory> {

}
