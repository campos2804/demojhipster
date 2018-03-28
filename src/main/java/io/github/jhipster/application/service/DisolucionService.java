package io.github.jhipster.application.service;

import io.github.jhipster.application.service.dto.DisolucionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Disolucion.
 */
public interface DisolucionService {

    /**
     * Save a disolucion.
     *
     * @param disolucionDTO the entity to save
     * @return the persisted entity
     */
    DisolucionDTO save(DisolucionDTO disolucionDTO);

    /**
     * Get all the disolucions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<DisolucionDTO> findAll(Pageable pageable);

    /**
     * Get the "id" disolucion.
     *
     * @param id the id of the entity
     * @return the entity
     */
    DisolucionDTO findOne(Long id);

    /**
     * Delete the "id" disolucion.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
