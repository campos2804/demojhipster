package io.github.jhipster.application.service;

import io.github.jhipster.application.service.dto.ModificacionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Modificacion.
 */
public interface ModificacionService {

    /**
     * Save a modificacion.
     *
     * @param modificacionDTO the entity to save
     * @return the persisted entity
     */
    ModificacionDTO save(ModificacionDTO modificacionDTO);

    /**
     * Get all the modificacions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ModificacionDTO> findAll(Pageable pageable);

    /**
     * Get the "id" modificacion.
     *
     * @param id the id of the entity
     * @return the entity
     */
    ModificacionDTO findOne(Long id);

    /**
     * Delete the "id" modificacion.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
