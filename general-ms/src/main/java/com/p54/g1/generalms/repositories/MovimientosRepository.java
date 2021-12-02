package com.p54.g1.generalms.repositories;

import com.p54.g1.generalms.models.Movimientos;
import com.p54.g1.generalms.models.Integrantes;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface MovimientosRepository extends MongoRepository<Movimientos, String> {
    List<Movimientos> findByIntegrantes (Integer idusuario);
}
