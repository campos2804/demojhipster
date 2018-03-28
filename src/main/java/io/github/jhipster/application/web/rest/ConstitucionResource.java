package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.service.ConstitucionService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.web.rest.util.HeaderUtil;
import io.github.jhipster.application.web.rest.util.PaginationUtil;
import io.github.jhipster.application.service.dto.ConstitucionDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Constitucion.
 */
@RestController
@RequestMapping("/api")
public class ConstitucionResource {

    private final Logger log = LoggerFactory.getLogger(ConstitucionResource.class);

    private static final String ENTITY_NAME = "constitucion";

    private final ConstitucionService constitucionService;

    public ConstitucionResource(ConstitucionService constitucionService) {
        this.constitucionService = constitucionService;
    }

    /**
     * POST  /constitucions : Create a new constitucion.
     *
     * @param constitucionDTO the constitucionDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new constitucionDTO, or with status 400 (Bad Request) if the constitucion has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/constitucions")
    @Timed
    public ResponseEntity<ConstitucionDTO> createConstitucion(@RequestBody ConstitucionDTO constitucionDTO) throws URISyntaxException {
        log.debug("REST request to save Constitucion : {}", constitucionDTO);
        if (constitucionDTO.getId() != null) {
            throw new BadRequestAlertException("A new constitucion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ConstitucionDTO result = constitucionService.save(constitucionDTO);
        return ResponseEntity.created(new URI("/api/constitucions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /constitucions : Updates an existing constitucion.
     *
     * @param constitucionDTO the constitucionDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated constitucionDTO,
     * or with status 400 (Bad Request) if the constitucionDTO is not valid,
     * or with status 500 (Internal Server Error) if the constitucionDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/constitucions")
    @Timed
    public ResponseEntity<ConstitucionDTO> updateConstitucion(@RequestBody ConstitucionDTO constitucionDTO) throws URISyntaxException {
        log.debug("REST request to update Constitucion : {}", constitucionDTO);
        if (constitucionDTO.getId() == null) {
            return createConstitucion(constitucionDTO);
        }
        ConstitucionDTO result = constitucionService.save(constitucionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, constitucionDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /constitucions : get all the constitucions.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of constitucions in body
     */
    @GetMapping("/constitucions")
    @Timed
    public ResponseEntity<List<ConstitucionDTO>> getAllConstitucions(Pageable pageable) {
        log.debug("REST request to get a page of Constitucions");
        Page<ConstitucionDTO> page = constitucionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/constitucions");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /constitucions/:id : get the "id" constitucion.
     *
     * @param id the id of the constitucionDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the constitucionDTO, or with status 404 (Not Found)
     */
    @GetMapping("/constitucions/{id}")
    @Timed
    public ResponseEntity<ConstitucionDTO> getConstitucion(@PathVariable Long id) {
        log.debug("REST request to get Constitucion : {}", id);
        ConstitucionDTO constitucionDTO = constitucionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(constitucionDTO));
    }

    /**
     * DELETE  /constitucions/:id : delete the "id" constitucion.
     *
     * @param id the id of the constitucionDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/constitucions/{id}")
    @Timed
    public ResponseEntity<Void> deleteConstitucion(@PathVariable Long id) {
        log.debug("REST request to delete Constitucion : {}", id);
        constitucionService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
