package com.p54.g1.generalms.models;

import org.springframework.data.annotation.Id;
import java.util.Date;

public class Gasto {
    @Id
    private String idgasto;
    private String idunidad;
    private String idcategoria;
    private String detalle;
    private Float valor;
    private Date fecha;

    public Gasto(String idunidad, String idgasto, String idcategoria, String detalle, Float valor, Date fecha) {
        this.idunidad = idunidad;
        this.idgasto = idgasto;
        this.idcategoria = idcategoria;
        this.detalle = detalle;
        this.valor = valor;
        this.fecha = fecha;
    }

    public String getIdunidad() {
        return idunidad;
    }

    public void setIdunidad(String idunidad) {
        this.idunidad = idunidad;
    }

    public String getIdgasto() {
        return idgasto;
    }

    public void setIdgasto(String idgasto) {
        this.idgasto = idgasto;
    }

    public String getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(String idcategoria) {
        this.idcategoria = idcategoria;
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
        valor = valor;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
