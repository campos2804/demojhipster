package io.github.jhipster.application.web.rest;

import com.codahale.metrics.annotation.Timed;
import io.github.jhipster.application.domain.ControlCambioRazon;

import io.github.jhipster.application.repository.ControlCambioRazonRepository;
import io.github.jhipster.application.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.application.web.rest.util.HeaderUtil;
import io.github.jhipster.application.service.dto.ControlCambioRazonDTO;
import io.github.jhipster.application.service.mapper.ControlCambioRazonMapper;
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
 * REST controller for managing ControlCambioRazon.
 */
@RestController
@RequestMapping("/api")
public class ControlCambioRazonResource {

    private final Logger log = LoggerFactory.getLogger(ControlCambioRazonResource.class);

    private static final String ENTITY_NAME = "controlCambioRazon";

    private final ControlCambioRazonRepository controlCambioRazonRepository;

    private final ControlCambioRazonMapper controlCambioRazonMapper;

    public ControlCambioRazonResource(ControlCambioRazonRepository controlCambioRazonRepository, ControlCambioRazonMapper controlCambioRazonMapper) {
        this.controlCambioRazonRepository = controlCambioRazonRepository;
        this.controlCambioRazonMapper = controlCambioRazonMapper;
    }

    /**
     * POST  /control-cambio-razons : Create a new controlCambioRazon.
     *
     * @param controlCambioRazonDTO the controlCambioRazonDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new controlCambioRazonDTO, or with status 400 (Bad Request) if the controlCambioRazon has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/control-cambio-razons")
    @Timed
    public ResponseEntity<ControlCambioRazonDTO> createControlCambioRazon(@RequestBody ControlCambioRazonDTO controlCambioRazonDTO) throws URISyntaxException {
        log.debug("REST request to save ControlCambioRazon : {}", controlCambioRazonDTO);
        if (controlCambioRazonDTO.getId() != null) {
            throw new BadRequestAlertException("A new controlCambioRazon cannot already have an ID", ENTITY_NAME, "idexists");
        }
        ControlCambioRazon controlCambioRazon = controlCambioRazonMapper.toEntity(controlCambioRazonDTO);
        controlCambioRazon = controlCambioRazonRepository.save(controlCambioRazon);
        ControlCambioRazonDTO result = controlCambioRazonMapper.toDto(controlCambioRazon);
        return ResponseEntity.created(new URI("/api/control-cambio-razons/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /control-cambio-razons : Updates an existing controlCambioRazon.
     *
     * @param controlCambioRazonDTO the controlCambioRazonDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated controlCambioRazonDTO,
     * or with status 400 (Bad Request) if the controlCambioRazonDTO is not valid,
     * or with status 500 (Internal Server Error) if the controlCambioRazonDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/control-cambio-razons")
    @Timed
    public ResponseEntity<ControlCambioRazonDTO> updateControlCambioRazon(@RequestBody ControlCambioRazonDTO controlCambioRazonDTO) throws URISyntaxException {
        log.debug("REST request to update ControlCambioRazon : {}", controlCambioRazonDTO);
        if (controlCambioRazonDTO.getId() == null) {
            return createControlCambioRazon(controlCambioRazonDTO);
        }
        ControlCambioRazon controlCambioRazon = controlCambioRazonMapper.toEntity(controlCambioRazonDTO);
        controlCambioRazon = controlCambioRazonRepository.save(controlCambioRazon);
        ControlCambioRazonDTO result = controlCambioRazonMapper.toDto(controlCambioRazon);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, controlCambioRazonDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /control-cambio-razons : get all the controlCambioRazons.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of controlCambioRazons in body
     */
    @GetMapping("/control-cambio-razons")
    @Timed
    public List<ControlCambioRazonDTO> getAllControlCambioRazons() {
        log.debug("REST request to get all ControlCambioRazons");
        List<ControlCambioRazon> controlCambioRazons = controlCambioRazonRepository.findAll();
        return controlCambioRazonMapper.toDto(controlCambioRazons);
        }

    /**
     * GET  /control-cambio-razons/:id : get the "id" controlCambioRazon.
     *
     * @param id the id of the controlCambioRazonDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the controlCambioRazonDTO, or with status 404 (Not Found)
     */
    @GetMapping("/control-cambio-razons/{id}")
    @Timed
    public ResponseEntity<ControlCambioRazonDTO> getControlCambioRazon(@PathVariable Long id) {
        log.debug("REST request to get ControlCambioRazon : {}", id);
        ControlCambioRazon controlCambioRazon = controlCambioRazonRepository.findOne(id);
        ControlCambioRazonDTO controlCambioRazonDTO = controlCambioRazonMapper.toDto(controlCambioRazon);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(controlCambioRazonDTO));
    }

    /**
     * DELETE  /control-cambio-razons/:id : delete the "id" controlCambioRazon.
     *
     * @param id the id of the controlCambioRazonDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/control-cambio-razons/{id}")
    @Timed
    public ResponseEntity<Void> deleteControlCambioRazon(@PathVariable Long id) {
        log.debug("REST request to delete ControlCambioRazon : {}", id);
        controlCambioRazonRepository.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
