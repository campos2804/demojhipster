package io.github.jhipster.application.service;

import io.github.jhipster.application.service.dto.ConstitucionDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Constitucion.
 */
public interface ConstitucionService {

    /**
     * Save a constitucion.
     *
     * @param constitucionDTO the entity to save
     * @return the persisted entity
     */
    ConstitucionDTO save(ConstitucionDTO constitucionDTO);

    /**
     * Get all the constitucions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<ConstitucionDTO> findAll(Pageable pageable);

    /**
     * Get the "id" constitucion.
     *
     * @param id the id of the entity
     * @return the entity
     */
    ConstitucionDTO findOne(Long id);

    /**
     * Delete the "id" constitucion.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
