package com.p54.g1.generalms.controllers;

import com.p54.g1.generalms.exceptions.IntegranteNotFoundException;
import com.p54.g1.generalms.exceptions.UnidadNotFoundException;
import com.p54.g1.generalms.models.Integrantes;
import com.p54.g1.generalms.models.UnidadHabitacional;
import com.p54.g1.generalms.repositories.IntegrantesRepository;
import com.p54.g1.generalms.repositories.UnidadRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class IntegranteController {
    private final IntegrantesRepository integrantesRepository;
    private final UnidadRepository unidadRepository;

    public IntegranteController(IntegrantesRepository integrantesRepository, UnidadRepository unidadRepository) {
        this.integrantesRepository = integrantesRepository;
        this.unidadRepository = unidadRepository;
    }

    @PostMapping("/integrantes")
    Integrantes newIntegrante(@RequestBody Integrantes integrantes) {
        UnidadHabitacional unidadHabitacional = unidadRepository.findById(integrantes.getIdunidad()).orElse(null);

        if(unidadHabitacional == null)
            throw new UnidadNotFoundException("No se encontro una unidad habitacional con el id: " + integrantes.getIdunidad());

        return integrantesRepository.save(integrantes);
    }

    @GetMapping("/integrantes/{idusuario}")
    Integrantes getIntegrante(@PathVariable String idusuario) {
        return integrantesRepository.findById(idusuario).orElseThrow(() -> new IntegranteNotFoundException("No se encontro un integrante con el Id: " + idusuario));
    }

    @GetMapping("/integrantes/unidad/{idunidad}")
    List<Integrantes> unidadIntegrantes(@PathVariable String idunidad) {
        UnidadHabitacional unidadHabitacional = unidadRepository.findById(idunidad).orElse(null);
        if (unidadHabitacional == null)
            throw new UnidadNotFoundException("No se encontro una unidad habitacional con el Id: "+ idunidad);
        List<Integrantes> integrantes = integrantesRepository.findByUnidadHabitacional(idunidad);
        return integrantes;
    }
}
