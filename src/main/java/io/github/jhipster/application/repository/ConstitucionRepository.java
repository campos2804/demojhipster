package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.Constitucion;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the Constitucion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ConstitucionRepository extends JpaRepository<Constitucion, Long> {

}
