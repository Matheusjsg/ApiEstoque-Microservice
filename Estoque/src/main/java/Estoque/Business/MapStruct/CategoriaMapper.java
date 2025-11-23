package Estoque.Business.MapStruct;



import Estoque.Business.dto.Request.CategoriaRequestDTO;
import Estoque.Business.dto.Response.CategoriaResponseDTO;
import Estoque.InfraStructure.entities.CategoriaEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoriaMapper {

    @Mapping(target = "id", ignore = true)
    CategoriaEntity toEntity(CategoriaRequestDTO dto);

    CategoriaResponseDTO toResponse(CategoriaEntity entity);
}
