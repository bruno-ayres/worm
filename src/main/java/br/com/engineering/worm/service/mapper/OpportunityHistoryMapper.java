package br.com.engineering.worm.service.mapper;

import br.com.engineering.worm.domain.*;
import br.com.engineering.worm.service.dto.OpportunityHistoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity OpportunityHistory and its DTO OpportunityHistoryDTO.
 */
@Mapper(componentModel = "spring", uses = {OpportunityMapper.class})
public interface OpportunityHistoryMapper extends EntityMapper<OpportunityHistoryDTO, OpportunityHistory> {

    @Mapping(source = "opportunity.id", target = "opportunityId")
    @Mapping(source = "opportunity.title", target = "opportunityTitle")
    OpportunityHistoryDTO toDto(OpportunityHistory opportunityHistory);

    @Mapping(source = "opportunityId", target = "opportunity")
    OpportunityHistory toEntity(OpportunityHistoryDTO opportunityHistoryDTO);

    default OpportunityHistory fromId(Long id) {
        if (id == null) {
            return null;
        }
        OpportunityHistory opportunityHistory = new OpportunityHistory();
        opportunityHistory.setId(id);
        return opportunityHistory;
    }
}
