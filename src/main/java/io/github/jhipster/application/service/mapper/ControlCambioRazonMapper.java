package io.github.jhipster.application.service.mapper;

import io.github.jhipster.application.domain.*;
import io.github.jhipster.application.service.dto.ControlCambioRazonDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ControlCambioRazon and its DTO ControlCambioRazonDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ControlCambioRazonMapper extends EntityMapper<ControlCambioRazonDTO, ControlCambioRazon> {



    default ControlCambioRazon fromId(Long id) {
        if (id == null) {
            return null;
        }
        ControlCambioRazon controlCambioRazon = new ControlCambioRazon();
        controlCambioRazon.setId(id);
        return controlCambioRazon;
    }
}
