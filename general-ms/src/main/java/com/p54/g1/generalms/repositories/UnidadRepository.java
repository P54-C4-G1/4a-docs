package com.p54.g1.generalms.repositories;

import com.p54.g1.generalms.models.UnidadHabitacional;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UnidadRepository extends MongoRepository<UnidadHabitacional, String> {
}
