package br.com.engineering.worm.service.mapper;

import br.com.engineering.worm.domain.*;
import br.com.engineering.worm.service.dto.OpportunityDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Opportunity and its DTO OpportunityDTO.
 */
@Mapper(componentModel = "spring", uses = {CustomerMapper.class, AccountManagerMapper.class})
public interface OpportunityMapper extends EntityMapper<OpportunityDTO, Opportunity> {

    @Mapping(source = "customer.id", target = "customerId")
    @Mapping(source = "customer.name", target = "customerName")
    @Mapping(source = "accountManager.id", target = "accountManagerId")
    @Mapping(source = "accountManager.name", target = "accountManagerName")
    OpportunityDTO toDto(Opportunity opportunity);

    @Mapping(target = "opportunityHistories", ignore = true)
    @Mapping(source = "customerId", target = "customer")
    @Mapping(source = "accountManagerId", target = "accountManager")
    Opportunity toEntity(OpportunityDTO opportunityDTO);

    default Opportunity fromId(Long id) {
        if (id == null) {
            return null;
        }
        Opportunity opportunity = new Opportunity();
        opportunity.setId(id);
        return opportunity;
    }
}
