package com.p54.g1.generalms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Gastos {
    @Id
    private Integer idunidad;
    private Integer idGasto;
    private Integer idCategoria;
    private String detalle;
    private Float Valor;
    private Date fecha;

    public Gastos(Integer idunidad, Integer idGasto, Integer idCategoria, String detalle, Float valor, Date fecha) {
        this.idunidad = idunidad;
        this.idGasto = idGasto;
        this.idCategoria = idCategoria;
        this.detalle = detalle;
        Valor = valor;
        this.fecha = fecha;
    }

    public Integer getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(Integer idunidad) {
        this.idunidad = idunidad;
    }

    public Integer getIdGasto() {
        return idGasto;
    }

    public void setIdGasto(Integer idGasto) {
        this.idGasto = idGasto;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
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
