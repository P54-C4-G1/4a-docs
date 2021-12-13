package com.p54.g1.generalms.repositories;

import com.p54.g1.generalms.models.UnidadHabitacional;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface UnidadHabitacionalRepository extends MongoRepository<UnidadHabitacional, String> {
    List<UnidadHabitacional> findByidusuario (String idusuario);
}
