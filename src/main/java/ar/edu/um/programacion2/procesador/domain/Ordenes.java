package ar.edu.um.programacion2.procesador.domain;

import java.io.Serializable;
import java.time.ZonedDateTime;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Ordenes.
 */
@Entity
@Table(name = "ordenes")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Ordenes implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @Column(name = "cliente")
    private Integer cliente;

    @Column(name = "accion_id")
    private Integer accionID;

    @Column(name = "accion")
    private String accion;

    @Column(name = "operacion")
    private String operacion;

    @Column(name = "cantidad_acciones")
    private Integer cantidadAcciones;

    @Column(name = "fecha_operacion")
    private ZonedDateTime fechaOperacion;

    @Column(name = "modo")
    private String modo;

    @Column(name = "operacion_exitosa")
    private Boolean operacionExitosa;

    @Column(name = "operacion_observaciones")
    private String operacionObservaciones;

    @Column(name = "ejecutada")
    private Boolean ejecutada;

    @Column(name = "reportada")
    private Boolean reportada;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Ordenes id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCliente() {
        return this.cliente;
    }

    public Ordenes cliente(Integer cliente) {
        this.setCliente(cliente);
        return this;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getAccionID() {
        return this.accionID;
    }

    public Ordenes accionID(Integer accionID) {
        this.setAccionID(accionID);
        return this;
    }

    public void setAccionID(Integer accionID) {
        this.accionID = accionID;
    }

    public String getAccion() {
        return this.accion;
    }

    public Ordenes accion(String accion) {
        this.setAccion(accion);
        return this;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getOperacion() {
        return this.operacion;
    }

    public Ordenes operacion(String operacion) {
        this.setOperacion(operacion);
        return this;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Integer getCantidadAcciones() {
        return this.cantidadAcciones;
    }

    public Ordenes cantidadAcciones(Integer cantidadAcciones) {
        this.setCantidadAcciones(cantidadAcciones);
        return this;
    }

    public void setCantidadAcciones(Integer cantidadAcciones) {
        this.cantidadAcciones = cantidadAcciones;
    }

    public ZonedDateTime getFechaOperacion() {
        return this.fechaOperacion;
    }

    public Ordenes fechaOperacion(ZonedDateTime fechaOperacion) {
        this.setFechaOperacion(fechaOperacion);
        return this;
    }

    public void setFechaOperacion(ZonedDateTime fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String getModo() {
        return this.modo;
    }

    public Ordenes modo(String modo) {
        this.setModo(modo);
        return this;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Boolean getOperacionExitosa() {
        return this.operacionExitosa;
    }

    public Ordenes operacionExitosa(Boolean operacionExitosa) {
        this.setOperacionExitosa(operacionExitosa);
        return this;
    }

    public void setOperacionExitosa(Boolean operacionExitosa) {
        this.operacionExitosa = operacionExitosa;
    }

    public String getOperacionObservaciones() {
        return this.operacionObservaciones;
    }

    public Ordenes operacionObservaciones(String operacionObservaciones) {
        this.setOperacionObservaciones(operacionObservaciones);
        return this;
    }

    public void setOperacionObservaciones(String operacionObservaciones) {
        this.operacionObservaciones = operacionObservaciones;
    }

    public Boolean getEjecutada() {
        return this.ejecutada;
    }

    public Ordenes ejecutada(Boolean ejecutada) {
        this.setEjecutada(ejecutada);
        return this;
    }

    public void setEjecutada(Boolean ejecutada) {
        this.ejecutada = ejecutada;
    }

    public Boolean getReportada() {
        return this.reportada;
    }

    public Ordenes reportada(Boolean reportada) {
        this.setReportada(reportada);
        return this;
    }

    public void setReportada(Boolean reportada) {
        this.reportada = reportada;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Ordenes)) {
            return false;
        }
        return id != null && id.equals(((Ordenes) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Ordenes{" +
            "id=" + getId() +
            ", cliente=" + getCliente() +
            ", accionID=" + getAccionID() +
            ", accion='" + getAccion() + "'" +
            ", operacion='" + getOperacion() + "'" +
            ", cantidadAcciones=" + getCantidadAcciones() +
            ", fechaOperacion='" + getFechaOperacion() + "'" +
            ", modo='" + getModo() + "'" +
            ", operacionExitosa='" + getOperacionExitosa() + "'" +
            ", operacionObservaciones='" + getOperacionObservaciones() + "'" +
            ", ejecutada='" + getEjecutada() + "'" +
            ", reportada='" + getReportada() + "'" +
            "}";
    }
}
