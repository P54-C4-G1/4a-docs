package com.p54.g1.generalms.controllers;

import com.p54.g1.generalms.exceptions.GastoNotFoundException;
import com.p54.g1.generalms.exceptions.CategoriaNotFoundException;
import com.p54.g1.generalms.exceptions.UnidadNotFoundException;
import com.p54.g1.generalms.models.Gastos;
import com.p54.g1.generalms.models.UnidadHabitacional;
import com.p54.g1.generalms.models.Categorias;
import com.p54.g1.generalms.repositories.CategoriasRepository;
import com.p54.g1.generalms.repositories.GastosRepository;
import com.p54.g1.generalms.repositories.UnidadRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Date;

@RestController
public class GastoController {
    private final GastosRepository gastosRepository;
    private final UnidadRepository unidadRepository;
    private final CategoriasRepository categoriasRepository;

    public GastoController(GastosRepository gastosRepository, UnidadRepository unidadRepository, CategoriasRepository categoriasRepository) {
        this.gastosRepository = gastosRepository;
        this.unidadRepository = unidadRepository;
        this.categoriasRepository = categoriasRepository;
    }

    @PostMapping("/gastos")
    Gastos newGasto(@RequestBody Gastos gastos) {
        UnidadHabitacional unidadHabitacional = unidadRepository.findById(gastos.getIdunidad()).orElse(null);
        Categorias categorias = categoriasRepository.findById(gastos.getIdCategoria()).orElse(null);

        if (unidadHabitacional == null)
            throw new UnidadNotFoundException("No se encontro una unidad habitacion con el id: " + gastos.getIdunidad());

        if (categorias == null)
            throw new CategoriaNotFoundException("No se encontro una categoria con el id: " + gastos.getIdCategoria());

        gastos.setFecha(new Date());
        return gastosRepository.save(gastos);
    }

    @GetMapping("/gastos/{idgasto}")
    Gastos getGasto(@PathVariable String idgasto) {
        return gastosRepository.findById(idgasto).orElseThrow(() -> new GastoNotFoundException("No se encontro un gasto con el Id: " + idgasto));
    }

    @GetMapping("/gastos/unidad/{idunidad}")
    List<Gastos> unidadGastos(@PathVariable String idunidad) {
        UnidadHabitacional unidadHabitacional = unidadRepository.findById(idunidad).orElse(null);
        if (unidadHabitacional == null)
            throw new UnidadNotFoundException("No se encontro una unidad habitacional con el id: " + idunidad);
        List<Gastos> gastos = gastosRepository.findByUnidadHabitacional(idunidad);
        return gastos;
    }

    @GetMapping("/gastos/categorias/{idcategoria}")
    List<Gastos> categoriaGastos(@PathVariable String idcategoria) {
        Categorias categorias = categoriasRepository.findById(idcategoria).orElse(null);
        if (categorias == null)
            throw new CategoriaNotFoundException("No se encontro una categoria con el id: " + idcategoria);
        List<Gastos> gastos = gastosRepository.findByCategorias(idcategoria);
        return gastos;
    }

}
