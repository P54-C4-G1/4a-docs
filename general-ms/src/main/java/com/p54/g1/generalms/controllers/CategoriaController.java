package com.p54.g1.generalms.controllers;

import com.p54.g1.generalms.exceptions.CategoriaNotFoundException;
import com.p54.g1.generalms.models.Categoria;
import com.p54.g1.generalms.models.Integrante;
import com.p54.g1.generalms.repositories.CategoriaRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CategoriaController {

    private final CategoriaRepository categoriaRepository;

    public CategoriaController(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @GetMapping("/categorias/{idcategoria}")
    Categoria getCategoria(@PathVariable String idcategoria) {
        return categoriaRepository.findById(idcategoria).orElseThrow( () -> new CategoriaNotFoundException("No se encontro una categoria con Id: " + idcategoria));
    }

    @GetMapping("/categorias")
    List<Categoria> getCategorias() {
        List<Categoria> categorias = categoriaRepository.findAll();
        return categorias;
    }

    @PostMapping("/categorias")
    Categoria newCategoria(@RequestBody Categoria categoria) {
        return categoriaRepository.save(categoria);
    }
}
