package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.ControlCambioRazon;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the ControlCambioRazon entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ControlCambioRazonRepository extends JpaRepository<ControlCambioRazon, Long> {

}
