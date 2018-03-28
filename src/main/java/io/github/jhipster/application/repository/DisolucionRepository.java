package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.Disolucion;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Disolucion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface DisolucionRepository extends JpaRepository<Disolucion, Long> {

}
