package io.github.jhipster.application.service.mapper;

import io.github.jhipster.application.domain.*;
import io.github.jhipster.application.service.dto.ConstitucionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Constitucion and its DTO ConstitucionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ConstitucionMapper extends EntityMapper<ConstitucionDTO, Constitucion> {



    default Constitucion fromId(Long id) {
        if (id == null) {
            return null;
        }
        Constitucion constitucion = new Constitucion();
        constitucion.setId(id);
        return constitucion;
    }
}
