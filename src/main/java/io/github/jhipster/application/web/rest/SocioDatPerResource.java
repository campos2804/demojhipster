package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.service.SocioDatPerService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.web.rest.util.HeaderUtil;
import io.github.jhipster.application.service.dto.SocioDatPerDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing SocioDatPer.
 */
@RestController
@RequestMapping("/api")
public class SocioDatPerResource {

    private final Logger log = LoggerFactory.getLogger(SocioDatPerResource.class);

    private static final String ENTITY_NAME = "socioDatPer";

    private final SocioDatPerService socioDatPerService;

    public SocioDatPerResource(SocioDatPerService socioDatPerService) {
        this.socioDatPerService = socioDatPerService;
    }

    /**
     * POST  /socio-dat-pers : Create a new socioDatPer.
     *
     * @param socioDatPerDTO the socioDatPerDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new socioDatPerDTO, or with status 400 (Bad Request) if the socioDatPer has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/socio-dat-pers")
    @Timed
    public ResponseEntity<SocioDatPerDTO> createSocioDatPer(@RequestBody SocioDatPerDTO socioDatPerDTO) throws URISyntaxException {
        log.debug("REST request to save SocioDatPer : {}", socioDatPerDTO);
        if (socioDatPerDTO.getId() != null) {
            throw new BadRequestAlertException("A new socioDatPer cannot already have an ID", ENTITY_NAME, "idexists");
        }
        SocioDatPerDTO result = socioDatPerService.save(socioDatPerDTO);
        return ResponseEntity.created(new URI("/api/socio-dat-pers/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /socio-dat-pers : Updates an existing socioDatPer.
     *
     * @param socioDatPerDTO the socioDatPerDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated socioDatPerDTO,
     * or with status 400 (Bad Request) if the socioDatPerDTO is not valid,
     * or with status 500 (Internal Server Error) if the socioDatPerDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/socio-dat-pers")
    @Timed
    public ResponseEntity<SocioDatPerDTO> updateSocioDatPer(@RequestBody SocioDatPerDTO socioDatPerDTO) throws URISyntaxException {
        log.debug("REST request to update SocioDatPer : {}", socioDatPerDTO);
        if (socioDatPerDTO.getId() == null) {
            return createSocioDatPer(socioDatPerDTO);
        }
        SocioDatPerDTO result = socioDatPerService.save(socioDatPerDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, socioDatPerDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /socio-dat-pers : get all the socioDatPers.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of socioDatPers in body
     */
    @GetMapping("/socio-dat-pers")
    @Timed
    public List<SocioDatPerDTO> getAllSocioDatPers() {
        log.debug("REST request to get all SocioDatPers");
        return socioDatPerService.findAll();
        }

    /**
     * GET  /socio-dat-pers/:id : get the "id" socioDatPer.
     *
     * @param id the id of the socioDatPerDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the socioDatPerDTO, or with status 404 (Not Found)
     */
    @GetMapping("/socio-dat-pers/{id}")
    @Timed
    public ResponseEntity<SocioDatPerDTO> getSocioDatPer(@PathVariable Long id) {
        log.debug("REST request to get SocioDatPer : {}", id);
        SocioDatPerDTO socioDatPerDTO = socioDatPerService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(socioDatPerDTO));
    }

    /**
     * DELETE  /socio-dat-pers/:id : delete the "id" socioDatPer.
     *
     * @param id the id of the socioDatPerDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/socio-dat-pers/{id}")
    @Timed
    public ResponseEntity<Void> deleteSocioDatPer(@PathVariable Long id) {
        log.debug("REST request to delete SocioDatPer : {}", id);
        socioDatPerService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
