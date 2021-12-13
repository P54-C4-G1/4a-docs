package com.p54.g1.generalms.controllers;

import com.p54.g1.generalms.exceptions.IntegranteNotFoundException;
import com.p54.g1.generalms.exceptions.UnidadHabitacionalNotFoundException;
import com.p54.g1.generalms.models.Integrante;
import com.p54.g1.generalms.models.UnidadHabitacional;
import com.p54.g1.generalms.repositories.UnidadHabitacionalRepository;
import com.p54.g1.generalms.repositories.IntegranteRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UnidadHabitacionalController {
    private final UnidadHabitacionalRepository unidadHabitacionalRepository;
    private final IntegranteRepository integranteRepository;

    public UnidadHabitacionalController(UnidadHabitacionalRepository unidadHabitacionalRepository, IntegranteRepository integranteRepository) {
        this.unidadHabitacionalRepository = unidadHabitacionalRepository;
        this.integranteRepository = integranteRepository;
    }

    @GetMapping("/unidades/{idunidad}")
    UnidadHabitacional getUnidad(@PathVariable String idunidad) {
        return unidadHabitacionalRepository.findById(idunidad).orElseThrow( () -> new UnidadHabitacionalNotFoundException("No se encontro una unidad habitacional con Id: " + idunidad));
    }

    @GetMapping("/unidades/integrante/{idusuario}")
    List<UnidadHabitacional> userUnidades(@PathVariable String idusuario) {
        Integrante integrante = integranteRepository.findById(idusuario).orElse(null);
        if (integrante == null)
            throw new IntegranteNotFoundException("No se encontro un integrante con el Id: " + idusuario);
        List<UnidadHabitacional> unidadHabitacionales = unidadHabitacionalRepository.findByidusuario(idusuario);
        return unidadHabitacionales;
    }

    @PostMapping("/unidades")
    UnidadHabitacional newUnidad(@RequestBody UnidadHabitacional unidadHabitacional) {
        return unidadHabitacionalRepository.save(unidadHabitacional);
    }

}
