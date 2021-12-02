package com.p54.g1.generalms.controllers;

import com.p54.g1.generalms.exceptions.MovimientoNotFoundException;
import com.p54.g1.generalms.exceptions.IntegranteNotFoundException;
import com.p54.g1.generalms.models.Movimientos;
import com.p54.g1.generalms.models.Integrantes;
import com.p54.g1.generalms.repositories.IntegrantesRepository;
import com.p54.g1.generalms.repositories.MovimientosRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Date;

@RestController
public class MovimientoController {
    private final MovimientosRepository movimientosRepository;
    private final IntegrantesRepository integrantesRepository;

    public MovimientoController(MovimientosRepository movimientosRepository, IntegrantesRepository integrantesRepository) {
        this.movimientosRepository = movimientosRepository;
        this.integrantesRepository = integrantesRepository;
    }

    @PostMapping("/movimientos")
    Movimientos newMovimiento(@RequestBody Movimientos movimientos) {
        Integrantes integrantes = integrantesRepository.findById(movimientos.getIdusuario()).orElse(null);
        if (integrantes == null)
            throw new IntegranteNotFoundException("No se encontro un integrante con el Id: " + movimientos.getIdusuario());
        movimientos.setFecha(new Date());
        return movimientosRepository.save(movimientos);
    }

    @GetMapping("/movimientos/{idmovimiento}")
    Movimientos getMovimiento(@PathVariable String idmovimiento) {
        return movimientosRepository.findById(idmovimiento)
                .orElseThrow(() -> new MovimientoNotFoundException("No se encontro ningún movimiento con el id: " + idmovimiento));
    }

    @GetMapping("/movimientos/integrante/{idusuario}")
    List<Movimientos> userMovimientos(@PathVariable String idusuario) {
        Integrantes integrantes = integrantesRepository.findById(idusuario).orElse(null);
        if (integrantes == null)
            throw new IntegranteNotFoundException("No se encontro un integrante con el Id: " + idusuario);
        List<Movimientos> movimientos = movimientosRepository.findByIntegrantes(idusuario);
        return movimientos;
    }
}
