package io.github.jhipster.application.service.impl;

import io.github.jhipster.application.service.SocioDatPerService;
import io.github.jhipster.application.domain.SocioDatPer;
import io.github.jhipster.application.repository.SocioDatPerRepository;
import io.github.jhipster.application.service.dto.SocioDatPerDTO;
import io.github.jhipster.application.service.mapper.SocioDatPerMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing SocioDatPer.
 */
@Service
@Transactional
public class SocioDatPerServiceImpl implements SocioDatPerService {

    private final Logger log = LoggerFactory.getLogger(SocioDatPerServiceImpl.class);

    private final SocioDatPerRepository socioDatPerRepository;

    private final SocioDatPerMapper socioDatPerMapper;

    public SocioDatPerServiceImpl(SocioDatPerRepository socioDatPerRepository, SocioDatPerMapper socioDatPerMapper) {
        this.socioDatPerRepository = socioDatPerRepository;
        this.socioDatPerMapper = socioDatPerMapper;
    }

    /**
     * Save a socioDatPer.
     *
     * @param socioDatPerDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public SocioDatPerDTO save(SocioDatPerDTO socioDatPerDTO) {
        log.debug("Request to save SocioDatPer : {}", socioDatPerDTO);
        SocioDatPer socioDatPer = socioDatPerMapper.toEntity(socioDatPerDTO);
        socioDatPer = socioDatPerRepository.save(socioDatPer);
        return socioDatPerMapper.toDto(socioDatPer);
    }

    /**
     * Get all the socioDatPers.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<SocioDatPerDTO> findAll() {
        log.debug("Request to get all SocioDatPers");
        return socioDatPerRepository.findAll().stream()
            .map(socioDatPerMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }

    /**
     * Get one socioDatPer by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public SocioDatPerDTO findOne(Long id) {
        log.debug("Request to get SocioDatPer : {}", id);
        SocioDatPer socioDatPer = socioDatPerRepository.findOne(id);
        return socioDatPerMapper.toDto(socioDatPer);
    }

    /**
     * Delete the socioDatPer by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete SocioDatPer : {}", id);
        socioDatPerRepository.delete(id);
    }
}
