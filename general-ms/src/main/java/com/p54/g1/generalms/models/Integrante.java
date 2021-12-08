package com.p54.g1.generalms.models;

import org.springframework.data.annotation.Id;

public class Integrante {
    @Id
    private String idusuario;
    private String idunidad;
    private Boolean administrador;
    private Float abono;

    public Integrante(String idunidad, String idusuario, Boolean administrador, Float abono) {
        this.idunidad = idunidad;
        this.idusuario = idusuario;
        this.administrador = administrador;
        this.abono = abono;
    }

    public String getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(String idunidad) {
        this.idunidad = idunidad;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
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
