package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.DisolucionService;
import io.github.jhipster.application.domain.Disolucion;
import io.github.jhipster.application.repository.DisolucionRepository;
import io.github.jhipster.application.service.dto.DisolucionDTO;
import io.github.jhipster.application.service.mapper.DisolucionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Disolucion.
 */
@Service
@Transactional
public class DisolucionServiceImpl implements DisolucionService {

    private final Logger log = LoggerFactory.getLogger(DisolucionServiceImpl.class);

    private final DisolucionRepository disolucionRepository;

    private final DisolucionMapper disolucionMapper;

    public DisolucionServiceImpl(DisolucionRepository disolucionRepository, DisolucionMapper disolucionMapper) {
        this.disolucionRepository = disolucionRepository;
        this.disolucionMapper = disolucionMapper;
    }

    /**
     * Save a disolucion.
     *
     * @param disolucionDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public DisolucionDTO save(DisolucionDTO disolucionDTO) {
        log.debug("Request to save Disolucion : {}", disolucionDTO);
        Disolucion disolucion = disolucionMapper.toEntity(disolucionDTO);
        disolucion = disolucionRepository.save(disolucion);
        return disolucionMapper.toDto(disolucion);
    }

    /**
     * Get all the disolucions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<DisolucionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Disolucions");
        return disolucionRepository.findAll(pageable)
            .map(disolucionMapper::toDto);
    }

    /**
     * Get one disolucion by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public DisolucionDTO findOne(Long id) {
        log.debug("Request to get Disolucion : {}", id);
        Disolucion disolucion = disolucionRepository.findOne(id);
        return disolucionMapper.toDto(disolucion);
    }

    /**
     * Delete the disolucion by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Disolucion : {}", id);
        disolucionRepository.delete(id);
    }
}
