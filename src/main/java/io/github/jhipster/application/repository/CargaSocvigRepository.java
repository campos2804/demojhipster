package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.CargaSocvig;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;


/**
 * Spring Data JPA repository for the CargaSocvig entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CargaSocvigRepository extends JpaRepository<CargaSocvig, Long> {

}
