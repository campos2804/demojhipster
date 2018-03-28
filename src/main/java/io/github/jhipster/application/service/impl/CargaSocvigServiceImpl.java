package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.CargaSocvigService;
import io.github.jhipster.application.domain.CargaSocvig;
import io.github.jhipster.application.repository.CargaSocvigRepository;
import io.github.jhipster.application.service.dto.CargaSocvigDTO;
import io.github.jhipster.application.service.mapper.CargaSocvigMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing CargaSocvig.
 */
@Service
@Transactional
public class CargaSocvigServiceImpl implements CargaSocvigService {

    private final Logger log = LoggerFactory.getLogger(CargaSocvigServiceImpl.class);

    private final CargaSocvigRepository cargaSocvigRepository;

    private final CargaSocvigMapper cargaSocvigMapper;

    public CargaSocvigServiceImpl(CargaSocvigRepository cargaSocvigRepository, CargaSocvigMapper cargaSocvigMapper) {
        this.cargaSocvigRepository = cargaSocvigRepository;
        this.cargaSocvigMapper = cargaSocvigMapper;
    }

    /**
     * Save a cargaSocvig.
     *
     * @param cargaSocvigDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public CargaSocvigDTO save(CargaSocvigDTO cargaSocvigDTO) {
        log.debug("Request to save CargaSocvig : {}", cargaSocvigDTO);
        CargaSocvig cargaSocvig = cargaSocvigMapper.toEntity(cargaSocvigDTO);
        cargaSocvig = cargaSocvigRepository.save(cargaSocvig);
        return cargaSocvigMapper.toDto(cargaSocvig);
    }

    /**
     * Get all the cargaSocvigs.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<CargaSocvigDTO> findAll() {
        log.debug("Request to get all CargaSocvigs");
        return cargaSocvigRepository.findAll().stream()
            .map(cargaSocvigMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one cargaSocvig by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public CargaSocvigDTO findOne(Long id) {
        log.debug("Request to get CargaSocvig : {}", id);
        CargaSocvig cargaSocvig = cargaSocvigRepository.findOne(id);
        return cargaSocvigMapper.toDto(cargaSocvig);
    }

    /**
     * Delete the cargaSocvig by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete CargaSocvig : {}", id);
        cargaSocvigRepository.delete(id);
    }
}
