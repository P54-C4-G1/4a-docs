package com.p54.g1.generalms.controllers;

import com.p54.g1.generalms.exceptions.GastoNotFoundException;
import com.p54.g1.generalms.exceptions.CategoriaNotFoundException;
import com.p54.g1.generalms.exceptions.UnidadHabitacionalNotFoundException;
import com.p54.g1.generalms.models.Gasto;
import com.p54.g1.generalms.models.UnidadHabitacional;
import com.p54.g1.generalms.models.Categoria;
import com.p54.g1.generalms.repositories.CategoriaRepository;
import com.p54.g1.generalms.repositories.GastoRepository;
import com.p54.g1.generalms.repositories.UnidadHabitacionalRepository;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
public class GastoController {
    private final GastoRepository gastoRepository;
    private final UnidadHabitacionalRepository unidadHabitacionalRepository;
    private final CategoriaRepository categoriaRepository;

    public GastoController(GastoRepository gastoRepository, UnidadHabitacionalRepository unidadHabitacionalRepository, CategoriaRepository categoriaRepository) {
        this.gastoRepository = gastoRepository;
        this.unidadHabitacionalRepository = unidadHabitacionalRepository;
        this.categoriaRepository = categoriaRepository;
    }

    @PostMapping("/gastos")
    Gasto newGasto(@RequestBody Gasto gasto) {
        UnidadHabitacional unidadHabitacional = unidadHabitacionalRepository.findById(gasto.getIdunidad()).orElse(null);
        Categoria categoria = categoriaRepository.findById(gasto.getIdcategoria()).orElse(null);

        if (unidadHabitacional == null)
            throw new UnidadHabitacionalNotFoundException("No se encontro una unidad habitacion con el id: " + gasto.getIdunidad());

        if (categoria == null)
            throw new CategoriaNotFoundException("No se encontro una categoria con el id: " + gasto.getIdcategoria());

        gasto.setFecha(new Date());
        return gastoRepository.save(gasto);
    }

    @GetMapping("/gastos/{idgasto}")
    Gasto getGasto(@PathVariable String idgasto) {
        return gastoRepository.findById(idgasto).orElseThrow(() -> new GastoNotFoundException("No se encontro un gasto con el Id: " + idgasto));
    }

    @GetMapping("/gastos/unidad/{idunidad}")
    List<Gasto> unidadGastos(@PathVariable String idunidad) {
        UnidadHabitacional unidadHabitacional = unidadHabitacionalRepository.findById(idunidad).orElse(null);
        if (unidadHabitacional == null)
            throw new UnidadHabitacionalNotFoundException("No se encontro una unidad habitacional con el id: " + idunidad);
        List<Gasto> gastos = gastoRepository.findByidunidad(idunidad);
        return gastos;
    }

    @GetMapping("/gastos/categorias/{idcategoria}")
    List<Gasto> categoriaGastos(@PathVariable String idcategoria) {
        Categoria categoria = categoriaRepository.findById(idcategoria).orElse(null);
        if (categoria == null)
            throw new CategoriaNotFoundException("No se encontro una categoria con el id: " + idcategoria);
        List<Gasto> gastos = gastoRepository.findByidcategoria(idcategoria);
        return gastos;
    }

}
