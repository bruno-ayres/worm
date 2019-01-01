package br.com.engineering.worm.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.com.engineering.worm.service.AccountManagerService;
import br.com.engineering.worm.web.rest.errors.BadRequestAlertException;
import br.com.engineering.worm.web.rest.util.HeaderUtil;
import br.com.engineering.worm.web.rest.util.PaginationUtil;
import br.com.engineering.worm.service.dto.AccountManagerDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing AccountManager.
 */
@RestController
@RequestMapping("/api")
public class AccountManagerResource {

    private final Logger log = LoggerFactory.getLogger(AccountManagerResource.class);

    private static final String ENTITY_NAME = "accountManager";

    private final AccountManagerService accountManagerService;

    public AccountManagerResource(AccountManagerService accountManagerService) {
        this.accountManagerService = accountManagerService;
    }

    /**
     * POST  /account-managers : Create a new accountManager.
     *
     * @param accountManagerDTO the accountManagerDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new accountManagerDTO, or with status 400 (Bad Request) if the accountManager has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/account-managers")
    @Timed
    public ResponseEntity<AccountManagerDTO> createAccountManager(@Valid @RequestBody AccountManagerDTO accountManagerDTO) throws URISyntaxException {
        log.debug("REST request to save AccountManager : {}", accountManagerDTO);
        if (accountManagerDTO.getId() != null) {
            throw new BadRequestAlertException("A new accountManager cannot already have an ID", ENTITY_NAME, "idexists");
        }
        AccountManagerDTO result = accountManagerService.save(accountManagerDTO);
        return ResponseEntity.created(new URI("/api/account-managers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /account-managers : Updates an existing accountManager.
     *
     * @param accountManagerDTO the accountManagerDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated accountManagerDTO,
     * or with status 400 (Bad Request) if the accountManagerDTO is not valid,
     * or with status 500 (Internal Server Error) if the accountManagerDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/account-managers")
    @Timed
    public ResponseEntity<AccountManagerDTO> updateAccountManager(@Valid @RequestBody AccountManagerDTO accountManagerDTO) throws URISyntaxException {
        log.debug("REST request to update AccountManager : {}", accountManagerDTO);
        if (accountManagerDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        AccountManagerDTO result = accountManagerService.save(accountManagerDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, accountManagerDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /account-managers : get all the accountManagers.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of accountManagers in body
     */
    @GetMapping("/account-managers")
    @Timed
    public ResponseEntity<List<AccountManagerDTO>> getAllAccountManagers(Pageable pageable) {
        log.debug("REST request to get a page of AccountManagers");
        Page<AccountManagerDTO> page = accountManagerService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/account-managers");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /account-managers/:id : get the "id" accountManager.
     *
     * @param id the id of the accountManagerDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the accountManagerDTO, or with status 404 (Not Found)
     */
    @GetMapping("/account-managers/{id}")
    @Timed
    public ResponseEntity<AccountManagerDTO> getAccountManager(@PathVariable Long id) {
        log.debug("REST request to get AccountManager : {}", id);
        Optional<AccountManagerDTO> accountManagerDTO = accountManagerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(accountManagerDTO);
    }

    /**
     * DELETE  /account-managers/:id : delete the "id" accountManager.
     *
     * @param id the id of the accountManagerDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/account-managers/{id}")
    @Timed
    public ResponseEntity<Void> deleteAccountManager(@PathVariable Long id) {
        log.debug("REST request to delete AccountManager : {}", id);
        accountManagerService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
