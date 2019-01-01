package br.com.engineering.worm.service;

import br.com.engineering.worm.domain.AccountManager;
import br.com.engineering.worm.repository.AccountManagerRepository;
import br.com.engineering.worm.service.dto.AccountManagerDTO;
import br.com.engineering.worm.service.mapper.AccountManagerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Service Implementation for managing AccountManager.
 */
@Service
@Transactional
public class AccountManagerService {

    private final Logger log = LoggerFactory.getLogger(AccountManagerService.class);

    private final AccountManagerRepository accountManagerRepository;

    private final AccountManagerMapper accountManagerMapper;

    public AccountManagerService(AccountManagerRepository accountManagerRepository, AccountManagerMapper accountManagerMapper) {
        this.accountManagerRepository = accountManagerRepository;
        this.accountManagerMapper = accountManagerMapper;
    }

    /**
     * Save a accountManager.
     *
     * @param accountManagerDTO the entity to save
     * @return the persisted entity
     */
    public AccountManagerDTO save(AccountManagerDTO accountManagerDTO) {
        log.debug("Request to save AccountManager : {}", accountManagerDTO);

        AccountManager accountManager = accountManagerMapper.toEntity(accountManagerDTO);
        accountManager = accountManagerRepository.save(accountManager);
        return accountManagerMapper.toDto(accountManager);
    }

    /**
     * Get all the accountManagers.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<AccountManagerDTO> findAll(Pageable pageable) {
        log.debug("Request to get all AccountManagers");
        return accountManagerRepository.findAll(pageable)
            .map(accountManagerMapper::toDto);
    }


    /**
     * Get one accountManager by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Optional<AccountManagerDTO> findOne(Long id) {
        log.debug("Request to get AccountManager : {}", id);
        return accountManagerRepository.findById(id)
            .map(accountManagerMapper::toDto);
    }

    /**
     * Delete the accountManager by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete AccountManager : {}", id);
        accountManagerRepository.deleteById(id);
    }
}
