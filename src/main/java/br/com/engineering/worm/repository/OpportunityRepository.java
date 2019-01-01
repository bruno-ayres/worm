package br.com.engineering.worm.repository;

import br.com.engineering.worm.domain.Opportunity;
import br.com.engineering.worm.domain.OpportunityHistory;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Opportunity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OpportunityRepository extends JpaRepository<Opportunity, Long>, QuerydslPredicateExecutor<Opportunity> {

}
