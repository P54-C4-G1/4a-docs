package com.p54.g1.generalms.repositories;

import com.p54.g1.generalms.models.Categorias;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoriasRepository extends MongoRepository<Categorias, String> {
}
