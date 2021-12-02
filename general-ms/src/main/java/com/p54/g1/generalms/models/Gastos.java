package com.p54.g1.generalms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Gastos {
    @Id
    private String idunidad;
    private String idGasto;
    private String idCategoria;
    private String detalle;
    private Float Valor;
    private Date fecha;

    public Gastos(String idunidad, String idGasto, String idCategoria, String detalle, Float valor, Date fecha) {
        this.idunidad = idunidad;
        this.idGasto = idGasto;
        this.idCategoria = idCategoria;
        this.detalle = detalle;
        Valor = valor;
        this.fecha = fecha;
    }

    public String getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(String idunidad) {
        this.idunidad = idunidad;
    }

    public String getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(String idGasto) {
        this.idGasto = idGasto;
    }

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Float getValor() {
        return Valor;
    }

    public void setValor(Float valor) {
        Valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
