package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.Modificacion;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Modificacion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ModificacionRepository extends JpaRepository<Modificacion, Long> {

}
