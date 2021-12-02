package com.p54.g1.generalms.models;

import org.springframework.data.annotation.Id;

public class Integrantes {
    @Id
    private Integer idunidad;
    private Integer idusuario;
    private Boolean administrador;
    private Float abono;

    public Integrantes(Integer idunidad, Integer idusuario, Boolean administrador, Float abono) {
        this.idunidad = idunidad;
        this.idusuario = idusuario;
        this.administrador = administrador;
        this.abono = abono;
    }

    public Integer getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(Integer idunidad) {
        this.idunidad = idunidad;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public Boolean getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Boolean administrador) {
        this.administrador = administrador;
    }

    public Float getAbono() {
        return abono;
    }

    public void setAbono(Float abono) {
        this.abono = abono;
    }
}
