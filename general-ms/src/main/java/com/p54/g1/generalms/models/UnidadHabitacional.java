package com.p54.g1.generalms.models;

import org.springframework.data.annotation.Id;

public class UnidadHabitacional {
    @Id
    private String idunidad;
    private String idusuario;
    private String nombre;

    public UnidadHabitacional(String idunidad, String idusuario, String nombre) {
        this.idunidad = idunidad;
        this.idusuario = idusuario;
        this.nombre = nombre;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

