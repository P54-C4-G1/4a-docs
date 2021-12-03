package com.p54.g1.generalms.repositories;

import com.p54.g1.generalms.models.Movimiento;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MovimientoRepository extends MongoRepository<Movimiento, String> {
    List<Movimiento> findByidusuario (String idusuario);
}
