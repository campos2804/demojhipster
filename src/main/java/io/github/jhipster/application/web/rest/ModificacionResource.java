package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.service.ModificacionService;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.web.rest.util.HeaderUtil;
import io.github.jhipster.application.web.rest.util.PaginationUtil;
import io.github.jhipster.application.service.dto.ModificacionDTO;
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
 * REST controller for managing Modificacion.
 */
@RestController
@RequestMapping("/api")
public class ModificacionResource {

    private final Logger log = LoggerFactory.getLogger(ModificacionResource.class);

    private static final String ENTITY_NAME = "modificacion";

    private final ModificacionService modificacionService;

    public ModificacionResource(ModificacionService modificacionService) {
        this.modificacionService = modificacionService;
    }

    /**
     * POST  /modificacions : Create a new modificacion.
     *
     * @param modificacionDTO the modificacionDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new modificacionDTO, or with status 400 (Bad Request) if the modificacion has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/modificacions")
    @Timed
    public ResponseEntity<ModificacionDTO> createModificacion(@RequestBody ModificacionDTO modificacionDTO) throws URISyntaxException {
        log.debug("REST request to save Modificacion : {}", modificacionDTO);
        if (modificacionDTO.getId() != null) {
            throw new BadRequestAlertException("A new modificacion cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ModificacionDTO result = modificacionService.save(modificacionDTO);
        return ResponseEntity.created(new URI("/api/modificacions/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /modificacions : Updates an existing modificacion.
     *
     * @param modificacionDTO the modificacionDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated modificacionDTO,
     * or with status 400 (Bad Request) if the modificacionDTO is not valid,
     * or with status 500 (Internal Server Error) if the modificacionDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/modificacions")
    @Timed
    public ResponseEntity<ModificacionDTO> updateModificacion(@RequestBody ModificacionDTO modificacionDTO) throws URISyntaxException {
        log.debug("REST request to update Modificacion : {}", modificacionDTO);
        if (modificacionDTO.getId() == null) {
            return createModificacion(modificacionDTO);
        }
        ModificacionDTO result = modificacionService.save(modificacionDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, modificacionDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /modificacions : get all the modificacions.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of modificacions in body
     */
    @GetMapping("/modificacions")
    @Timed
    public ResponseEntity<List<ModificacionDTO>> getAllModificacions(Pageable pageable) {
        log.debug("REST request to get a page of Modificacions");
        Page<ModificacionDTO> page = modificacionService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/modificacions");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /modificacions/:id : get the "id" modificacion.
     *
     * @param id the id of the modificacionDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the modificacionDTO, or with status 404 (Not Found)
     */
    @GetMapping("/modificacions/{id}")
    @Timed
    public ResponseEntity<ModificacionDTO> getModificacion(@PathVariable Long id) {
        log.debug("REST request to get Modificacion : {}", id);
        ModificacionDTO modificacionDTO = modificacionService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(modificacionDTO));
    }

    /**
     * DELETE  /modificacions/:id : delete the "id" modificacion.
     *
     * @param id the id of the modificacionDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/modificacions/{id}")
    @Timed
    public ResponseEntity<Void> deleteModificacion(@PathVariable Long id) {
        log.debug("REST request to delete Modificacion : {}", id);
        modificacionService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
