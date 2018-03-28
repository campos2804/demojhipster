package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.service.DisolucionService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.web.rest.util.HeaderUtil;
import io.github.jhipster.application.web.rest.util.PaginationUtil;
import io.github.jhipster.application.service.dto.DisolucionDTO;
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
 * REST controller for managing Disolucion.
 */
@RestController
@RequestMapping("/api")
public class DisolucionResource {

    private final Logger log = LoggerFactory.getLogger(DisolucionResource.class);

    private static final String ENTITY_NAME = "disolucion";

    private final DisolucionService disolucionService;

    public DisolucionResource(DisolucionService disolucionService) {
        this.disolucionService = disolucionService;
    }

    /**
     * POST  /disolucions : Create a new disolucion.
     *
     * @param disolucionDTO the disolucionDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new disolucionDTO, or with status 400 (Bad Request) if the disolucion has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/disolucions")
    @Timed
    public ResponseEntity<DisolucionDTO> createDisolucion(@RequestBody DisolucionDTO disolucionDTO) throws URISyntaxException {
        log.debug("REST request to save Disolucion : {}", disolucionDTO);
        if (disolucionDTO.getId() != null) {
            throw new BadRequestAlertException("A new disolucion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        DisolucionDTO result = disolucionService.save(disolucionDTO);
        return ResponseEntity.created(new URI("/api/disolucions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /disolucions : Updates an existing disolucion.
     *
     * @param disolucionDTO the disolucionDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated disolucionDTO,
     * or with status 400 (Bad Request) if the disolucionDTO is not valid,
     * or with status 500 (Internal Server Error) if the disolucionDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/disolucions")
    @Timed
    public ResponseEntity<DisolucionDTO> updateDisolucion(@RequestBody DisolucionDTO disolucionDTO) throws URISyntaxException {
        log.debug("REST request to update Disolucion : {}", disolucionDTO);
        if (disolucionDTO.getId() == null) {
            return createDisolucion(disolucionDTO);
        }
        DisolucionDTO result = disolucionService.save(disolucionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, disolucionDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /disolucions : get all the disolucions.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of disolucions in body
     */
    @GetMapping("/disolucions")
    @Timed
    public ResponseEntity<List<DisolucionDTO>> getAllDisolucions(Pageable pageable) {
        log.debug("REST request to get a page of Disolucions");
        Page<DisolucionDTO> page = disolucionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/disolucions");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /disolucions/:id : get the "id" disolucion.
     *
     * @param id the id of the disolucionDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the disolucionDTO, or with status 404 (Not Found)
     */
    @GetMapping("/disolucions/{id}")
    @Timed
    public ResponseEntity<DisolucionDTO> getDisolucion(@PathVariable Long id) {
        log.debug("REST request to get Disolucion : {}", id);
        DisolucionDTO disolucionDTO = disolucionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(disolucionDTO));
    }

    /**
     * DELETE  /disolucions/:id : delete the "id" disolucion.
     *
     * @param id the id of the disolucionDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/disolucions/{id}")
    @Timed
    public ResponseEntity<Void> deleteDisolucion(@PathVariable Long id) {
        log.debug("REST request to delete Disolucion : {}", id);
        disolucionService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
