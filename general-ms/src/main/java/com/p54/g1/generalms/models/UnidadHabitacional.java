package com.p54.g1.generalms.models;

import org.springframework.data.annotation.Id;

public class UnidadHabitacional {
    @Id
    private Integer idunidad;
    private Integer idusuario;
    private String nombre;

    public UnidadHabitacional(Integer idunidad, Integer idusuario, String nombre) {
        this.idunidad = idunidad;
        this.idusuario = idusuario;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

