package io.github.jhipster.application.service.mapper;

import io.github.jhipster.application.domain.*;
import io.github.jhipster.application.service.dto.CargaSocvigDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity CargaSocvig and its DTO CargaSocvigDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface CargaSocvigMapper extends EntityMapper<CargaSocvigDTO, CargaSocvig> {



    default CargaSocvig fromId(Long id) {
        if (id == null) {
            return null;
        }
        CargaSocvig cargaSocvig = new CargaSocvig();
        cargaSocvig.setId(id);
        return cargaSocvig;
    }
}
