package io.github.jhipster.application.service;

import io.github.jhipster.application.service.dto.CargaSocvigDTO;
import java.util.List;

/**
 * Service Interface for managing CargaSocvig.
 */
public interface CargaSocvigService {

    /**
     * Save a cargaSocvig.
     *
     * @param cargaSocvigDTO the entity to save
     * @return the persisted entity
     */
    CargaSocvigDTO save(CargaSocvigDTO cargaSocvigDTO);

    /**
     * Get all the cargaSocvigs.
     *
     * @return the list of entities
     */
    List<CargaSocvigDTO> findAll();

    /**
     * Get the "id" cargaSocvig.
     *
     * @param id the id of the entity
     * @return the entity
     */
    CargaSocvigDTO findOne(Long id);

    /**
     * Delete the "id" cargaSocvig.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
