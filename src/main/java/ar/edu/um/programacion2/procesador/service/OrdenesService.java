package ar.edu.um.programacion2.procesador.service;

import ar.edu.um.programacion2.procesador.domain.Ordenes;
import ar.edu.um.programacion2.procesador.repository.OrdenesRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link Ordenes}.
 */
@Service
@Transactional
public class OrdenesService {

    private final Logger log = LoggerFactory.getLogger(OrdenesService.class);

    private final OrdenesRepository ordenesRepository;

    public OrdenesService(OrdenesRepository ordenesRepository) {
        this.ordenesRepository = ordenesRepository;
    }

    /**
     * Save a ordenes.
     *
     * @param ordenes the entity to save.
     * @return the persisted entity.
     */
    public Ordenes save(Ordenes ordenes) {
        log.debug("Request to save Ordenes : {}", ordenes);
        return ordenesRepository.save(ordenes);
    }

    /**
     * Update a ordenes.
     *
     * @param ordenes the entity to save.
     * @return the persisted entity.
     */
    public Ordenes update(Ordenes ordenes) {
        log.debug("Request to update Ordenes : {}", ordenes);
        return ordenesRepository.save(ordenes);
    }

    /**
     * Partially update a ordenes.
     *
     * @param ordenes the entity to update partially.
     * @return the persisted entity.
     */
    public Optional<Ordenes> partialUpdate(Ordenes ordenes) {
        log.debug("Request to partially update Ordenes : {}", ordenes);

        return ordenesRepository
            .findById(ordenes.getId())
            .map(existingOrdenes -> {
                if (ordenes.getCliente() != null) {
                    existingOrdenes.setCliente(ordenes.getCliente());
                }
                if (ordenes.getAccionID() != null) {
                    existingOrdenes.setAccionID(ordenes.getAccionID());
                }
                if (ordenes.getAccion() != null) {
                    existingOrdenes.setAccion(ordenes.getAccion());
                }
                if (ordenes.getOperacion() != null) {
                    existingOrdenes.setOperacion(ordenes.getOperacion());
                }
                if (ordenes.getCantidadAcciones() != null) {
                    existingOrdenes.setCantidadAcciones(ordenes.getCantidadAcciones());
                }
                if (ordenes.getFechaOperacion() != null) {
                    existingOrdenes.setFechaOperacion(ordenes.getFechaOperacion());
                }
                if (ordenes.getModo() != null) {
                    existingOrdenes.setModo(ordenes.getModo());
                }
                if (ordenes.getOperacionExitosa() != null) {
                    existingOrdenes.setOperacionExitosa(ordenes.getOperacionExitosa());
                }
                if (ordenes.getOperacionObservaciones() != null) {
                    existingOrdenes.setOperacionObservaciones(ordenes.getOperacionObservaciones());
                }
                if (ordenes.getEjecutada() != null) {
                    existingOrdenes.setEjecutada(ordenes.getEjecutada());
                }
                if (ordenes.getReportada() != null) {
                    existingOrdenes.setReportada(ordenes.getReportada());
                }

                return existingOrdenes;
            })
            .map(ordenesRepository::save);
    }

    /**
     * Get all the ordenes.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public Page<Ordenes> findAll(Pageable pageable) {
        log.debug("Request to get all Ordenes");
        return ordenesRepository.findAll(pageable);
    }

    /**
     * Get one ordenes by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Ordenes> findOne(Long id) {
        log.debug("Request to get Ordenes : {}", id);
        return ordenesRepository.findById(id);
    }

    /**
     * Delete the ordenes by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Ordenes : {}", id);
        ordenesRepository.deleteById(id);
    }
}
