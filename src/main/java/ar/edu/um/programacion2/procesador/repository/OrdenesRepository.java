package ar.edu.um.programacion2.procesador.repository;

import ar.edu.um.programacion2.procesador.domain.Ordenes;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data JPA repository for the Ordenes entity.
 */
@SuppressWarnings("unused")
@Repository
public interface OrdenesRepository extends JpaRepository<Ordenes, Long> {}
