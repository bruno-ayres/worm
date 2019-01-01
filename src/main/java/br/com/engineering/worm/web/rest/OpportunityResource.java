package br.com.engineering.worm.web.rest;

import com.codahale.metrics.annotation.Timed;
import br.com.engineering.worm.service.OpportunityService;
import br.com.engineering.worm.web.rest.errors.BadRequestAlertException;
import br.com.engineering.worm.web.rest.util.HeaderUtil;
import br.com.engineering.worm.web.rest.util.PaginationUtil;
import br.com.engineering.worm.service.dto.OpportunityDTO;
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
 * REST controller for managing Opportunity.
 */
@RestController
@RequestMapping("/api")
public class OpportunityResource {

    private final Logger log = LoggerFactory.getLogger(OpportunityResource.class);

    private static final String ENTITY_NAME = "opportunity";

    private final OpportunityService opportunityService;

    public OpportunityResource(OpportunityService opportunityService) {
        this.opportunityService = opportunityService;
    }

    /**
     * POST  /opportunities : Create a new opportunity.
     *
     * @param opportunityDTO the opportunityDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new opportunityDTO, or with status 400 (Bad Request) if the opportunity has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/opportunities")
    @Timed
    public ResponseEntity<OpportunityDTO> createOpportunity(@Valid @RequestBody OpportunityDTO opportunityDTO) throws URISyntaxException {
        log.debug("REST request to save Opportunity : {}", opportunityDTO);
        if (opportunityDTO.getId() != null) {
            throw new BadRequestAlertException("A new opportunity cannot already have an ID", ENTITY_NAME, "idexists");
        }
        OpportunityDTO result = opportunityService.save(opportunityDTO);
        return ResponseEntity.created(new URI("/api/opportunities/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /opportunities : Updates an existing opportunity.
     *
     * @param opportunityDTO the opportunityDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated opportunityDTO,
     * or with status 400 (Bad Request) if the opportunityDTO is not valid,
     * or with status 500 (Internal Server Error) if the opportunityDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/opportunities")
    @Timed
    public ResponseEntity<OpportunityDTO> updateOpportunity(@Valid @RequestBody OpportunityDTO opportunityDTO) throws URISyntaxException {
        log.debug("REST request to update Opportunity : {}", opportunityDTO);
        if (opportunityDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        OpportunityDTO result = opportunityService.save(opportunityDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, opportunityDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /opportunities : get all the opportunities.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of opportunities in body
     */
    @GetMapping("/opportunities")
    @Timed
    public ResponseEntity<List<OpportunityDTO>> getAllOpportunities(Pageable pageable) {
        log.debug("REST request to get a page of Opportunities");
        Page<OpportunityDTO> page = opportunityService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/opportunities");
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * GET  /opportunities/:id : get the "id" opportunity.
     *
     * @param id the id of the opportunityDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the opportunityDTO, or with status 404 (Not Found)
     */
    @GetMapping("/opportunities/{id}")
    @Timed
    public ResponseEntity<OpportunityDTO> getOpportunity(@PathVariable Long id) {
        log.debug("REST request to get Opportunity : {}", id);
        Optional<OpportunityDTO> opportunityDTO = opportunityService.findOne(id);
        return ResponseUtil.wrapOrNotFound(opportunityDTO);
    }

    /**
     * DELETE  /opportunities/:id : delete the "id" opportunity.
     *
     * @param id the id of the opportunityDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/opportunities/{id}")
    @Timed
    public ResponseEntity<Void> deleteOpportunity(@PathVariable Long id) {
        log.debug("REST request to delete Opportunity : {}", id);
        opportunityService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
