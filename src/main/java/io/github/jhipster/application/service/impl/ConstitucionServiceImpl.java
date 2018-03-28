package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.ConstitucionService;
import io.github.jhipster.application.domain.Constitucion;
import io.github.jhipster.application.repository.ConstitucionRepository;
import io.github.jhipster.application.service.dto.ConstitucionDTO;
import io.github.jhipster.application.service.mapper.ConstitucionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Constitucion.
 */
@Service
@Transactional
public class ConstitucionServiceImpl implements ConstitucionService {

    private final Logger log = LoggerFactory.getLogger(ConstitucionServiceImpl.class);

    private final ConstitucionRepository constitucionRepository;

    private final ConstitucionMapper constitucionMapper;

    public ConstitucionServiceImpl(ConstitucionRepository constitucionRepository, ConstitucionMapper constitucionMapper) {
        this.constitucionRepository = constitucionRepository;
        this.constitucionMapper = constitucionMapper;
    }

    /**
     * Save a constitucion.
     *
     * @param constitucionDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ConstitucionDTO save(ConstitucionDTO constitucionDTO) {
        log.debug("Request to save Constitucion : {}", constitucionDTO);
        Constitucion constitucion = constitucionMapper.toEntity(constitucionDTO);
        constitucion = constitucionRepository.save(constitucion);
        return constitucionMapper.toDto(constitucion);
    }

    /**
     * Get all the constitucions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ConstitucionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Constitucions");
        return constitucionRepository.findAll(pageable)
            .map(constitucionMapper::toDto);
    }

    /**
     * Get one constitucion by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ConstitucionDTO findOne(Long id) {
        log.debug("Request to get Constitucion : {}", id);
        Constitucion constitucion = constitucionRepository.findOne(id);
        return constitucionMapper.toDto(constitucion);
    }

    /**
     * Delete the constitucion by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Constitucion : {}", id);
        constitucionRepository.delete(id);
    }
}
