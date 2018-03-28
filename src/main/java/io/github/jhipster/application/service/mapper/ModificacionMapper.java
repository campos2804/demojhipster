package io.github.jhipster.application.service.mapper;

import io.github.jhipster.application.domain.*;
import io.github.jhipster.application.service.dto.ModificacionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Modificacion and its DTO ModificacionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ModificacionMapper extends EntityMapper<ModificacionDTO, Modificacion> {



    default Modificacion fromId(Long id) {
        if (id == null) {
            return null;
        }
        Modificacion modificacion = new Modificacion();
        modificacion.setId(id);
        return modificacion;
    }
}
