package ies_alcores.api_inv.repository;

import ies_alcores.api_inv.model.Producto;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoRepository extends MongoRepository<Producto, Integer> {

    List<Producto> findByCategoriaNombre(String nombre);

    @Query("{ 'Modelo': { $regex: ?0, $options: 'i' } }")
    List<Producto> buscarPorModeloQuery(String regex);

}

