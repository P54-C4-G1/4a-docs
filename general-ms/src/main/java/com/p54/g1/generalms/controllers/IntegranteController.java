package com.p54.g1.generalms.controllers;

import com.p54.g1.generalms.exceptions.IntegranteNotFoundException;
import com.p54.g1.generalms.exceptions.UnidadHabitacionalNotFoundException;
import com.p54.g1.generalms.models.Integrante;
import com.p54.g1.generalms.models.UnidadHabitacional;
import com.p54.g1.generalms.repositories.IntegranteRepository;
import com.p54.g1.generalms.repositories.UnidadHabitacionalRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class IntegranteController {
    private final IntegranteRepository integranteRepository;
    private final UnidadHabitacionalRepository unidadHabitacionalRepository;

    public IntegranteController(IntegranteRepository integranteRepository, UnidadHabitacionalRepository unidadHabitacionalRepository) {
        this.integranteRepository = integranteRepository;
        this.unidadHabitacionalRepository = unidadHabitacionalRepository;
    }

    @PostMapping("/integrantes")
    Integrante newIntegrante(@RequestBody Integrante integrante) {
        UnidadHabitacional unidadHabitacional = unidadHabitacionalRepository.findById(integrante.getIdunidad()).orElse(null);

        if(unidadHabitacional == null)
            throw new UnidadHabitacionalNotFoundException("No se encontro una unidad habitacional con el id: " + integrante.getIdunidad());

        return integranteRepository.save(integrante);
    }

    @GetMapping("/integrantes/{idusuario}")
    Integrante getIntegrante(@PathVariable String idusuario) {
        return integranteRepository.findById(idusuario).orElseThrow(() -> new IntegranteNotFoundException("No se encontro un integrante con el Id: " + idusuario));
    }

    @GetMapping("/integrantes/unidad/{idunidad}")
    List<Integrante> unidadIntegrantes(@PathVariable String idunidad) {
        UnidadHabitacional unidadHabitacional = unidadHabitacionalRepository.findById(idunidad).orElse(null);
        if (unidadHabitacional == null)
            throw new UnidadHabitacionalNotFoundException("No se encontro una unidad habitacional con el Id: "+ idunidad);
        List<Integrante> integrantes = integranteRepository.findByidunidad(idunidad);
        return integrantes;
    }
}
