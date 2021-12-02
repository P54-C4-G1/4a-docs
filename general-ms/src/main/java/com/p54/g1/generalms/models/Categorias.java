package com.p54.g1.generalms.models;

import org.springframework.data.annotation.Id;

public class Categorias {
    @Id
    private Integer idcategoria;
    private String nombre;

    public Categorias(Integer idcategoria, String nombre) {
        this.idcategoria = idcategoria;
        this.nombre = nombre;
    }

    public Integer getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Integer idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
