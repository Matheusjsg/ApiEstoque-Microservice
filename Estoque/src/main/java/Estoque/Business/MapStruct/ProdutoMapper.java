package Estoque.Business.MapStruct;

import Estoque.Business.dto.Request.ProdutoRequestDTO;
import Estoque.Business.dto.Response.CategoriaResponseDTO;
import Estoque.Business.dto.Response.ProdutoResponseDTO;
import Estoque.InfraStructure.entities.CategoriaEntity;
import Estoque.InfraStructure.entities.ImagemEntity;
import Estoque.InfraStructure.entities.ProductsEntity;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

   @Mapping(target = "id", ignore = true)
  @Mapping(target = "slug", ignore = true) // slug pode ser gerado no service
   @Mapping(target = "categoria", source = "categoriaId", qualifiedByName = "mapCategoria")
  @Mapping(target = "imagens", source = "imagens", qualifiedByName = "mapImagensStringToEntity")
   ProductsEntity paraProdutoEntity(ProdutoRequestDTO dto);

   @Mapping(target = "categoria", source = "categoria", qualifiedByName = "mapCategoriaResponse")
   @Mapping(target = "imagens", source = "imagens", qualifiedByName = "mapImagensEntityToString")
   ProdutoResponseDTO paraProdutoResponse(ProductsEntity entity);


    List<ProdutoResponseDTO> paraListarProdutoResponse(List<ProductsEntity> entities);


    // -------- Métodos auxiliares --------

    // Categoria do requestDTO -> CategoriaEntity
    @Named("mapCategoria")
    default CategoriaEntity mapCategoria(Long categoriaId) {
        if (categoriaId == null) return null;
        CategoriaEntity categoria = new CategoriaEntity();
        categoria.setId(categoriaId);
        return categoria;
    }

    // CategoriaEntity -> CategoriaResponseDTO
    @Named("mapCategoriaResponse")
    default CategoriaResponseDTO mapCategoriaResponse(CategoriaEntity categoria) {
        if (categoria == null) return null;
        return new CategoriaResponseDTO(categoria.getId(), categoria.getNome());
    }

    // Imagens do requestDTO (String) -> Entity
    @Named("mapImagensStringToEntity")
    default List<ImagemEntity> mapImagensStringToEntity(List<String> imagens) {
        if (imagens == null) return null;
        return imagens.stream().map(nome -> {
            ImagemEntity imagem = new ImagemEntity();
            imagem.setNomeArquivo(nome);
            return imagem;
        }).toList();
    }

    // Imagens do Entity -> ResponseDTO (String)
    @Named("mapImagensEntityToString")
    default List<String> mapImagensEntityToString(List<ImagemEntity> imagens) {
        if (imagens == null) return null;
        return imagens.stream()
                .map(ImagemEntity::getNomeArquivo)
                .toList();
    }
}
