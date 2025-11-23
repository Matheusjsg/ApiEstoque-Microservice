package Estoque.InfraStructure.repositories;

import Estoque.InfraStructure.entities.ProductsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductsRepository extends JpaRepository<ProductsEntity, Long>{


    List<ProductsEntity> findByCategoria_NomeIgnoreCase(String nome);
}
