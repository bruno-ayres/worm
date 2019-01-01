package br.com.engineering.worm.service;

import br.com.engineering.worm.domain.Opportunity;
import br.com.engineering.worm.repository.OpportunityRepository;
import br.com.engineering.worm.service.dto.OpportunityDTO;
import br.com.engineering.worm.service.mapper.OpportunityMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing Opportunity.
 */
@Service
@Transactional
public class OpportunityService {

    private final Logger log = LoggerFactory.getLogger(OpportunityService.class);

    private final OpportunityRepository opportunityRepository;

    private final OpportunityMapper opportunityMapper;

    public OpportunityService(OpportunityRepository opportunityRepository, OpportunityMapper opportunityMapper) {
        this.opportunityRepository = opportunityRepository;
        this.opportunityMapper = opportunityMapper;
    }

    /**
     * Save a opportunity.
     *
     * @param opportunityDTO the entity to save
     * @return the persisted entity
     */
    public OpportunityDTO save(OpportunityDTO opportunityDTO) {
        log.debug("Request to save Opportunity : {}", opportunityDTO);

        Opportunity opportunity = opportunityMapper.toEntity(opportunityDTO);
        opportunity = opportunityRepository.save(opportunity);
        return opportunityMapper.toDto(opportunity);
    }

    /**
     * Get all the opportunities.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<OpportunityDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Opportunities");
        return opportunityRepository.findAll(pageable)
            .map(opportunityMapper::toDto);
    }


    /**
     * Get one opportunity by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<OpportunityDTO> findOne(Long id) {
        log.debug("Request to get Opportunity : {}", id);
        return opportunityRepository.findById(id)
            .map(opportunityMapper::toDto);
    }

    /**
     * Delete the opportunity by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Opportunity : {}", id);
        opportunityRepository.deleteById(id);
    }
}
