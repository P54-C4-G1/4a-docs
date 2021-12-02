package com.p54.g1.generalms.controllers;

import com.p54.g1.generalms.exceptions.CategoriaNotFoundException;
import com.p54.g1.generalms.exceptions.UnidadNotFoundException;
import com.p54.g1.generalms.exceptions.IntegranteNotFoundException;
import com.p54.g1.generalms.models.Categorias;
import com.p54.g1.generalms.models.UnidadHabitacional;
import com.p54.g1.generalms.models.Integrantes;
import com.p54.g1.generalms.repositories.CategoriasRepository;
import com.p54.g1.generalms.repositories.UnidadRepository;
import com.p54.g1.generalms.repositories.IntegrantesRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class UnidadController {
    private final UnidadRepository unidadRepository;

    public UnidadController(UnidadRepository unidadRepository) {
        this.unidadRepository = unidadRepository;
    }

    @GetMapping("/unidades/{idunidad}")
    UnidadHabitacional getUnidad(@PathVariable String idunidad) {
        return unidadRepository.findById(idunidad).orElseThrow( () -> new UnidadNotFoundException("No se encontro una unidad habitacional con Id: " + idunidad));
    }

    @PostMapping("/unidades")
    UnidadHabitacional newUnidad(@RequestBody UnidadHabitacional unidadHabitacional) {
        return unidadRepository.save(unidadHabitacional);
    }

}
