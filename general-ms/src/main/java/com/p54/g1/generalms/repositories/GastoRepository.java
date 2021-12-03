package com.p54.g1.generalms.repositories;

import com.p54.g1.generalms.models.Gasto;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface GastoRepository extends MongoRepository<Gasto, String> {
    List<Gasto> findByidunidad(String idunidad);
    List<Gasto> findByidcategoria(String idcategoria);
}
