package com.p54.g1.generalms.controllers;

import com.p54.g1.generalms.exceptions.UnidadHabitacionalNotFoundException;
import com.p54.g1.generalms.models.UnidadHabitacional;
import com.p54.g1.generalms.repositories.UnidadHabitacionalRepository;
import org.springframework.web.bind.annotation.*;

@RestController
public class UnidadHabitacionalController {
    private final UnidadHabitacionalRepository unidadHabitacionalRepository;

    public UnidadHabitacionalController(UnidadHabitacionalRepository unidadHabitacionalRepository) {
        this.unidadHabitacionalRepository = unidadHabitacionalRepository;
    }

    @GetMapping("/unidades/{idunidad}")
    UnidadHabitacional getUnidad(@PathVariable String idunidad) {
        return unidadHabitacionalRepository.findById(idunidad).orElseThrow( () -> new UnidadHabitacionalNotFoundException("No se encontro una unidad habitacional con Id: " + idunidad));
    }

    @PostMapping("/unidades")
    UnidadHabitacional newUnidad(@RequestBody UnidadHabitacional unidadHabitacional) {
        return unidadHabitacionalRepository.save(unidadHabitacional);
    }

}
