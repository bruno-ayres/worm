package br.com.engineering.worm.service;

import br.com.engineering.worm.domain.OpportunityHistory;
import br.com.engineering.worm.repository.OpportunityHistoryRepository;
import br.com.engineering.worm.service.dto.OpportunityHistoryDTO;
import br.com.engineering.worm.service.mapper.OpportunityHistoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing OpportunityHistory.
 */
@Service
@Transactional
public class OpportunityHistoryService {

    private final Logger log = LoggerFactory.getLogger(OpportunityHistoryService.class);

    private final OpportunityHistoryRepository opportunityHistoryRepository;

    private final OpportunityHistoryMapper opportunityHistoryMapper;

    public OpportunityHistoryService(OpportunityHistoryRepository opportunityHistoryRepository, OpportunityHistoryMapper opportunityHistoryMapper) {
        this.opportunityHistoryRepository = opportunityHistoryRepository;
        this.opportunityHistoryMapper = opportunityHistoryMapper;
    }

    /**
     * Save a opportunityHistory.
     *
     * @param opportunityHistoryDTO the entity to save
     * @return the persisted entity
     */
    public OpportunityHistoryDTO save(OpportunityHistoryDTO opportunityHistoryDTO) {
        log.debug("Request to save OpportunityHistory : {}", opportunityHistoryDTO);

        OpportunityHistory opportunityHistory = opportunityHistoryMapper.toEntity(opportunityHistoryDTO);
        opportunityHistory = opportunityHistoryRepository.save(opportunityHistory);
        return opportunityHistoryMapper.toDto(opportunityHistory);
    }

    /**
     * Get all the opportunityHistories.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<OpportunityHistoryDTO> findAll(Pageable pageable) {
        log.debug("Request to get all OpportunityHistories");
        return opportunityHistoryRepository.findAll(pageable)
            .map(opportunityHistoryMapper::toDto);
    }


    /**
     * Get one opportunityHistory by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<OpportunityHistoryDTO> findOne(Long id) {
        log.debug("Request to get OpportunityHistory : {}", id);
        return opportunityHistoryRepository.findById(id)
            .map(opportunityHistoryMapper::toDto);
    }

    /**
     * Delete the opportunityHistory by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete OpportunityHistory : {}", id);
        opportunityHistoryRepository.deleteById(id);
    }
}
