package com.p54.g1.generalms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Movimientos {
    @Id
    private Integer idmovimientos;
    private Date fecha;
    private Integer idusuario;
    private String detalle;
    private Float valor;

    public Movimientos(Integer idmovimientos, Date fecha, Integer idusuario, String detalle, Float valor) {
        this.idmovimientos = idmovimientos;
        this.fecha = fecha;
        this.idusuario = idusuario;
        this.detalle = detalle;
        this.valor = valor;
    }

    public Integer getIdmovimientos() {
        return idmovimientos;
    }

    public void setIdmovimientos(Integer idmovimientos) {
        this.idmovimientos = idmovimientos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Integer idusuario) {
        this.idusuario = idusuario;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }
}
