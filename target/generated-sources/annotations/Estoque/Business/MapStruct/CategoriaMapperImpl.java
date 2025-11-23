package Estoque.Business.MapStruct;

import Estoque.Business.dto.Request.CategoriaRequestDTO;
import Estoque.Business.dto.Response.CategoriaResponseDTO;
import Estoque.InfraStructure.entities.CategoriaEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-20T17:55:05-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Debian)"
)
@Component
public class CategoriaMapperImpl implements CategoriaMapper {

    @Override
    public CategoriaEntity toEntity(CategoriaRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CategoriaEntity categoriaEntity = new CategoriaEntity();

        categoriaEntity.setNome( dto.getNome() );

        return categoriaEntity;
    }

    @Override
    public CategoriaResponseDTO toResponse(CategoriaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Long id = null;
        String nome = null;

        id = entity.getId();
        nome = entity.getNome();

        CategoriaResponseDTO categoriaResponseDTO = new CategoriaResponseDTO( id, nome );

        return categoriaResponseDTO;
    }
}
