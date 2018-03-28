package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.service.CargaSocvigService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.web.rest.util.HeaderUtil;
import io.github.jhipster.application.service.dto.CargaSocvigDTO;
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
 * REST controller for managing CargaSocvig.
 */
@RestController
@RequestMapping("/api")
public class CargaSocvigResource {

    private final Logger log = LoggerFactory.getLogger(CargaSocvigResource.class);

    private static final String ENTITY_NAME = "cargaSocvig";

    private final CargaSocvigService cargaSocvigService;

    public CargaSocvigResource(CargaSocvigService cargaSocvigService) {
        this.cargaSocvigService = cargaSocvigService;
    }

    /**
     * POST  /carga-socvigs : Create a new cargaSocvig.
     *
     * @param cargaSocvigDTO the cargaSocvigDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new cargaSocvigDTO, or with status 400 (Bad Request) if the cargaSocvig has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/carga-socvigs")
    @Timed
    public ResponseEntity<CargaSocvigDTO> createCargaSocvig(@RequestBody CargaSocvigDTO cargaSocvigDTO) throws URISyntaxException {
        log.debug("REST request to save CargaSocvig : {}", cargaSocvigDTO);
        if (cargaSocvigDTO.getId() != null) {
            throw new BadRequestAlertException("A new cargaSocvig cannot already have an ID", ENTITY_NAME, "idexists");
        }
        CargaSocvigDTO result = cargaSocvigService.save(cargaSocvigDTO);
        return ResponseEntity.created(new URI("/api/carga-socvigs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /carga-socvigs : Updates an existing cargaSocvig.
     *
     * @param cargaSocvigDTO the cargaSocvigDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated cargaSocvigDTO,
     * or with status 400 (Bad Request) if the cargaSocvigDTO is not valid,
     * or with status 500 (Internal Server Error) if the cargaSocvigDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/carga-socvigs")
    @Timed
    public ResponseEntity<CargaSocvigDTO> updateCargaSocvig(@RequestBody CargaSocvigDTO cargaSocvigDTO) throws URISyntaxException {
        log.debug("REST request to update CargaSocvig : {}", cargaSocvigDTO);
        if (cargaSocvigDTO.getId() == null) {
            return createCargaSocvig(cargaSocvigDTO);
        }
        CargaSocvigDTO result = cargaSocvigService.save(cargaSocvigDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, cargaSocvigDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /carga-socvigs : get all the cargaSocvigs.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of cargaSocvigs in body
     */
    @GetMapping("/carga-socvigs")
    @Timed
    public List<CargaSocvigDTO> getAllCargaSocvigs() {
        log.debug("REST request to get all CargaSocvigs");
        return cargaSocvigService.findAll();
        }

    /**
     * GET  /carga-socvigs/:id : get the "id" cargaSocvig.
     *
     * @param id the id of the cargaSocvigDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the cargaSocvigDTO, or with status 404 (Not Found)
     */
    @GetMapping("/carga-socvigs/{id}")
    @Timed
    public ResponseEntity<CargaSocvigDTO> getCargaSocvig(@PathVariable Long id) {
        log.debug("REST request to get CargaSocvig : {}", id);
        CargaSocvigDTO cargaSocvigDTO = cargaSocvigService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(cargaSocvigDTO));
    }

    /**
     * DELETE  /carga-socvigs/:id : delete the "id" cargaSocvig.
     *
     * @param id the id of the cargaSocvigDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/carga-socvigs/{id}")
    @Timed
    public ResponseEntity<Void> deleteCargaSocvig(@PathVariable Long id) {
        log.debug("REST request to delete CargaSocvig : {}", id);
        cargaSocvigService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
