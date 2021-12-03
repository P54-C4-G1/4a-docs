package com.p54.g1.generalms.controllers;

import com.p54.g1.generalms.exceptions.MovimientoNotFoundException;
import com.p54.g1.generalms.exceptions.IntegranteNotFoundException;
import com.p54.g1.generalms.models.Movimiento;
import com.p54.g1.generalms.models.Integrante;
import com.p54.g1.generalms.repositories.IntegranteRepository;
import com.p54.g1.generalms.repositories.MovimientoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Date;

@RestController
public class MovimientoController {
    private final MovimientoRepository movimientoRepository;
    private final IntegranteRepository integranteRepository;

    public MovimientoController(MovimientoRepository movimientoRepository, IntegranteRepository integranteRepository) {
        this.movimientoRepository = movimientoRepository;
        this.integranteRepository = integranteRepository;
    }

    @PostMapping("/movimientos")
    Movimiento newMovimiento(@RequestBody Movimiento movimiento) {
        Integrante integrante = integranteRepository.findById(movimiento.getIdusuario()).orElse(null);
        if (integrante == null)
            throw new IntegranteNotFoundException("No se encontro un integrante con el Id: " + movimiento.getIdusuario());
        movimiento.setFecha(new Date());
        return movimientoRepository.save(movimiento);
    }

    @GetMapping("/movimientos/{idmovimiento}")
    Movimiento getMovimiento(@PathVariable String idmovimiento) {
        return movimientoRepository.findById(idmovimiento)
                .orElseThrow(() -> new MovimientoNotFoundException("No se encontro ningún movimiento con el id: " + idmovimiento));
    }

    @GetMapping("/movimientos/integrante/{idusuario}")
    List<Movimiento> userMovimientos(@PathVariable String idusuario) {
        Integrante integrante = integranteRepository.findById(idusuario).orElse(null);
        if (integrante == null)
            throw new IntegranteNotFoundException("No se encontro un integrante con el Id: " + idusuario);
        List<Movimiento> movimientos = movimientoRepository.findByidusuario(idusuario);
        return movimientos;
    }
}
