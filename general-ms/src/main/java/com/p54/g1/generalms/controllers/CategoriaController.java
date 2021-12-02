package com.p54.g1.generalms.controllers;

import com.p54.g1.generalms.exceptions.CategoriaNotFoundException;
import com.p54.g1.generalms.models.Categorias;
import com.p54.g1.generalms.repositories.CategoriasRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class CategoriaController {

    private final CategoriasRepository categoriasRepository;

    public CategoriaController(CategoriasRepository categoriasRepository) {
        this.categoriasRepository = categoriasRepository;
    }

    @GetMapping("/categorias/{idcategoria}")
    Categorias getCategoria(@PathVariable String idcategoria) {
        return categoriasRepository.findById(idcategoria).orElseThrow( () -> new CategoriaNotFoundException("No se encontro una categoria con Id: " + idcategoria));
    }

    @PostMapping("/categorias")
    Categorias newCategoria(@RequestBody Categorias categorias) {
        return categoriasRepository.save(categorias);
    }
}
