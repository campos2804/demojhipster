package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.SocioService;
import io.github.jhipster.application.domain.Socio;
import io.github.jhipster.application.repository.SocioRepository;
import io.github.jhipster.application.service.dto.SocioDTO;
import io.github.jhipster.application.service.mapper.SocioMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Service Implementation for managing Socio.
 */
@Service
@Transactional
public class SocioServiceImpl implements SocioService {

    private final Logger log = LoggerFactory.getLogger(SocioServiceImpl.class);

    private final SocioRepository socioRepository;

    private final SocioMapper socioMapper;

    public SocioServiceImpl(SocioRepository socioRepository, SocioMapper socioMapper) {
        this.socioRepository = socioRepository;
        this.socioMapper = socioMapper;
    }

    /**
     * Save a socio.
     *
     * @param socioDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SocioDTO save(SocioDTO socioDTO) {
        log.debug("Request to save Socio : {}", socioDTO);
        Socio socio = socioMapper.toEntity(socioDTO);
        socio = socioRepository.save(socio);
        return socioMapper.toDto(socio);
    }

    /**
     * Get all the socios.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public Page<SocioDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Socios");
        return socioRepository.findAll(pageable)
            .map(socioMapper::toDto);
    }

    /**
     * Get one socio by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SocioDTO findOne(Long id) {
        log.debug("Request to get Socio : {}", id);
        Socio socio = socioRepository.findOne(id);
        return socioMapper.toDto(socio);
    }

    /**
     * Delete the socio by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Socio : {}", id);
        socioRepository.delete(id);
    }
}
