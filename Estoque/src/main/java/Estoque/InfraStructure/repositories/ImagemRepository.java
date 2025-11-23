package Estoque.InfraStructure.repositories;


import Estoque.InfraStructure.entities.ImagemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagemRepository extends JpaRepository<ImagemEntity, Long> {
}
