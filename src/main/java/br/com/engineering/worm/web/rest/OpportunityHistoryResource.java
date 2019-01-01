package br.com.engineering.worm.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.com.engineering.worm.service.OpportunityHistoryService;
import br.com.engineering.worm.web.rest.errors.BadRequestAlertException;
import br.com.engineering.worm.web.rest.util.HeaderUtil;
import br.com.engineering.worm.web.rest.util.PaginationUtil;
import br.com.engineering.worm.service.dto.OpportunityHistoryDTO;
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
 * REST controller for managing OpportunityHistory.
 */
@RestController
@RequestMapping("/api")
public class OpportunityHistoryResource {

    private final Logger log = LoggerFactory.getLogger(OpportunityHistoryResource.class);

    private static final String ENTITY_NAME = "opportunityHistory";

    private final OpportunityHistoryService opportunityHistoryService;

    public OpportunityHistoryResource(OpportunityHistoryService opportunityHistoryService) {
        this.opportunityHistoryService = opportunityHistoryService;
    }

    /**
     * POST  /opportunity-histories : Create a new opportunityHistory.
     *
     * @param opportunityHistoryDTO the opportunityHistoryDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new opportunityHistoryDTO, or with status 400 (Bad Request) if the opportunityHistory has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/opportunity-histories")
    @Timed
    public ResponseEntity<OpportunityHistoryDTO> createOpportunityHistory(@Valid @RequestBody OpportunityHistoryDTO opportunityHistoryDTO) throws URISyntaxException {
        log.debug("REST request to save OpportunityHistory : {}", opportunityHistoryDTO);
        if (opportunityHistoryDTO.getId() != null) {
            throw new BadRequestAlertException("A new opportunityHistory cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OpportunityHistoryDTO result = opportunityHistoryService.save(opportunityHistoryDTO);
        return ResponseEntity.created(new URI("/api/opportunity-histories/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /opportunity-histories : Updates an existing opportunityHistory.
     *
     * @param opportunityHistoryDTO the opportunityHistoryDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated opportunityHistoryDTO,
     * or with status 400 (Bad Request) if the opportunityHistoryDTO is not valid,
     * or with status 500 (Internal Server Error) if the opportunityHistoryDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/opportunity-histories")
    @Timed
    public ResponseEntity<OpportunityHistoryDTO> updateOpportunityHistory(@Valid @RequestBody OpportunityHistoryDTO opportunityHistoryDTO) throws URISyntaxException {
        log.debug("REST request to update OpportunityHistory : {}", opportunityHistoryDTO);
        if (opportunityHistoryDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OpportunityHistoryDTO result = opportunityHistoryService.save(opportunityHistoryDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, opportunityHistoryDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /opportunity-histories : get all the opportunityHistories.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of opportunityHistories in body
     */
    @GetMapping("/opportunity-histories")
    @Timed
    public ResponseEntity<List<OpportunityHistoryDTO>> getAllOpportunityHistories(Pageable pageable) {
        log.debug("REST request to get a page of OpportunityHistories");
        Page<OpportunityHistoryDTO> page = opportunityHistoryService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/opportunity-histories");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /opportunity-histories/:id : get the "id" opportunityHistory.
     *
     * @param id the id of the opportunityHistoryDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the opportunityHistoryDTO, or with status 404 (Not Found)
     */
    @GetMapping("/opportunity-histories/{id}")
    @Timed
    public ResponseEntity<OpportunityHistoryDTO> getOpportunityHistory(@PathVariable Long id) {
        log.debug("REST request to get OpportunityHistory : {}", id);
        Optional<OpportunityHistoryDTO> opportunityHistoryDTO = opportunityHistoryService.findOne(id);
        return ResponseUtil.wrapOrNotFound(opportunityHistoryDTO);
    }

    /**
     * DELETE  /opportunity-histories/:id : delete the "id" opportunityHistory.
     *
     * @param id the id of the opportunityHistoryDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/opportunity-histories/{id}")
    @Timed
    public ResponseEntity<Void> deleteOpportunityHistory(@PathVariable Long id) {
        log.debug("REST request to delete OpportunityHistory : {}", id);
        opportunityHistoryService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
