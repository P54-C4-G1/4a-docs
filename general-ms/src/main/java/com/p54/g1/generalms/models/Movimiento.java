package com.p54.g1.generalms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Movimiento {
    @Id
    private String idmovimiento;
    private Date fecha;
    private String idusuario;
    private String detalle;
    private Float valor;

    public Movimiento(String idmovimiento, Date fecha, String idusuario, String detalle, Float valor) {
        this.idmovimiento = idmovimiento;
        this.fecha = fecha;
        this.idusuario = idusuario;
        this.detalle = detalle;
        this.valor = valor;
    }

    public String getIdmovimiento() {
        return idmovimiento;
    }

    public void setIdmovimiento(String idmovimiento) {
        this.idmovimiento = idmovimiento;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(String idusuario) {
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
