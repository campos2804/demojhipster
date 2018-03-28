package io.github.jhipster.application.service;

import io.github.jhipster.application.service.dto.SocioDatPerDTO;
import java.util.List;

/**
 * Service Interface for managing SocioDatPer.
 */
public interface SocioDatPerService {

    /**
     * Save a socioDatPer.
     *
     * @param socioDatPerDTO the entity to save
     * @return the persisted entity
     */
    SocioDatPerDTO save(SocioDatPerDTO socioDatPerDTO);

    /**
     * Get all the socioDatPers.
     *
     * @return the list of entities
     */
    List<SocioDatPerDTO> findAll();

    /**
     * Get the "id" socioDatPer.
     *
     * @param id the id of the entity
     * @return the entity
     */
    SocioDatPerDTO findOne(Long id);

    /**
     * Delete the "id" socioDatPer.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
