package io.github.jhipster.application.service;

import io.github.jhipster.application.service.dto.SocioDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing Socio.
 */
public interface SocioService {

    /**
     * Save a socio.
     *
     * @param socioDTO the entity to save
     * @return the persisted entity
     */
    SocioDTO save(SocioDTO socioDTO);

    /**
     * Get all the socios.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    Page<SocioDTO> findAll(Pageable pageable);

    /**
     * Get the "id" socio.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SocioDTO findOne(Long id);

    /**
     * Delete the "id" socio.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
