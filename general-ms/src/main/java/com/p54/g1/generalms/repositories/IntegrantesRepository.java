package com.p54.g1.generalms.repositories;

import com.p54.g1.generalms.models.Integrantes;
import com.p54.g1.generalms.models.UnidadHabitacional;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface IntegrantesRepository extends MongoRepository<Integrantes, String> {
    List<Integrantes> findByUnidadHabitacional (String idunidad);
}
