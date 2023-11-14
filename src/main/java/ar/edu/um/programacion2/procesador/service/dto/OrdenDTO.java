package ar.edu.um.programacion2.procesador.service.dto;

import java.time.ZonedDateTime;

public class OrdenDTO {

    private Long id;
    private Integer cliente;
    private Integer accionID;
    private String accion;
    private String operacion;
    private Integer cantidadAcciones;
    private ZonedDateTime fechaOperacion;
    private String modo;
    private Boolean operacionExitosa;
    private String operacionObservaciones;
    private Boolean ejecutada;
    private Boolean reportada;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCliente() {
        return cliente;
    }

    public void setCliente(Integer cliente) {
        this.cliente = cliente;
    }

    public Integer getAccionID() {
        return accionID;
    }

    public void setAccionID(Integer accionID) {
        this.accionID = accionID;
    }

    public String getAccion() {
        return accion;
    }

    public void setAccion(String accion) {
        this.accion = accion;
    }

    public String getOperacion() {
        return operacion;
    }

    public void setOperacion(String operacion) {
        this.operacion = operacion;
    }

    public Integer getCantidadAcciones() {
        return cantidadAcciones;
    }

    public void setCantidadAcciones(Integer cantidadAcciones) {
        this.cantidadAcciones = cantidadAcciones;
    }

    public ZonedDateTime getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(ZonedDateTime fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public Boolean getOperacionExitosa() {
        return operacionExitosa;
    }

    public void setOperacionExitosa(Boolean operacionExitosa) {
        this.operacionExitosa = operacionExitosa;
    }

    public String getOperacionObservaciones() {
        return operacionObservaciones;
    }

    public void setOperacionObservaciones(String operacionObservaciones) {
        this.operacionObservaciones = operacionObservaciones;
    }

    public Boolean getEjecutada() {
        return ejecutada;
    }

    public void setEjecutada(Boolean ejecutada) {
        this.ejecutada = ejecutada;
    }

    public Boolean getReportada() {
        return reportada;
    }

    public void setReportada(Boolean reportada) {
        this.reportada = reportada;
    }
}
