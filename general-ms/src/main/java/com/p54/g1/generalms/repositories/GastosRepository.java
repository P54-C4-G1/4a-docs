package com.p54.g1.generalms.repositories;

import com.p54.g1.generalms.models.Gastos;
import com.p54.g1.generalms.models.Integrantes;
import com.p54.g1.generalms.models.Categorias;
import com.p54.g1.generalms.models.UnidadHabitacional;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.List;

public interface GastosRepository extends MongoRepository<Gastos, String> {
    List<Gastos> findByIntegrantes(Integer idgasto);
    List<Gastos> findByUnidadHabitacional(Integer idunidad);
    List<Gastos> findByCategorias(Integer idcategoria);
}
