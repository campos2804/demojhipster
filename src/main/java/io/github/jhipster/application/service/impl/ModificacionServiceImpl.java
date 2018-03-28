package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.ModificacionService;
import io.github.jhipster.application.domain.Modificacion;
import io.github.jhipster.application.repository.ModificacionRepository;
import io.github.jhipster.application.service.dto.ModificacionDTO;
import io.github.jhipster.application.service.mapper.ModificacionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Modificacion.
 */
@Service
@Transactional
public class ModificacionServiceImpl implements ModificacionService {

    private final Logger log = LoggerFactory.getLogger(ModificacionServiceImpl.class);

    private final ModificacionRepository modificacionRepository;

    private final ModificacionMapper modificacionMapper;

    public ModificacionServiceImpl(ModificacionRepository modificacionRepository, ModificacionMapper modificacionMapper) {
        this.modificacionRepository = modificacionRepository;
        this.modificacionMapper = modificacionMapper;
    }

    /**
     * Save a modificacion.
     *
     * @param modificacionDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public ModificacionDTO save(ModificacionDTO modificacionDTO) {
        log.debug("Request to save Modificacion : {}", modificacionDTO);
        Modificacion modificacion = modificacionMapper.toEntity(modificacionDTO);
        modificacion = modificacionRepository.save(modificacion);
        return modificacionMapper.toDto(modificacion);
    }

    /**
     * Get all the modificacions.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<ModificacionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Modificacions");
        return modificacionRepository.findAll(pageable)
            .map(modificacionMapper::toDto);
    }

    /**
     * Get one modificacion by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public ModificacionDTO findOne(Long id) {
        log.debug("Request to get Modificacion : {}", id);
        Modificacion modificacion = modificacionRepository.findOne(id);
        return modificacionMapper.toDto(modificacion);
    }

    /**
     * Delete the modificacion by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Modificacion : {}", id);
        modificacionRepository.delete(id);
    }
}
