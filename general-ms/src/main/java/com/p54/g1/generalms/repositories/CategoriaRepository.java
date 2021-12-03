package com.p54.g1.generalms.repositories;

import com.p54.g1.generalms.models.Categoria;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriaRepository extends MongoRepository<Categoria, String> {
}
