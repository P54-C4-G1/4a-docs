package com.p54.g1.generalms.repositories;

import com.p54.g1.generalms.models.Integrante;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface IntegranteRepository extends MongoRepository<Integrante, String> {
    List<Integrante> findByidunidad (String idunidad);
}
