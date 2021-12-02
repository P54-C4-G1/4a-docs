package com.p54.g1.generalms.models;

import org.springframework.data.annotation.Id;

public class Categorias {
    @Id
    private String idcategoria;
    private String nombre;

    public Categorias(String idcategoria, String nombre) {
        this.idcategoria = idcategoria;
        this.nombre = nombre;
    }

    public String getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(String idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
