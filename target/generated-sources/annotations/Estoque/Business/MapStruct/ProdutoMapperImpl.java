package Estoque.Business.MapStruct;

import Estoque.Business.dto.Request.ProdutoRequestDTO;
import Estoque.Business.dto.Response.CategoriaResponseDTO;
import Estoque.Business.dto.Response.ProdutoResponseDTO;
import Estoque.InfraStructure.entities.ProductsEntity;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-11-20T17:55:05-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.16 (Debian)"
)
@Component
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public ProductsEntity paraProdutoEntity(ProdutoRequestDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProductsEntity productsEntity = new ProductsEntity();

        productsEntity.setCategoria( mapCategoria( dto.getCategoriaId() ) );
        productsEntity.setImagens( mapImagensStringToEntity( dto.getImagens() ) );
        productsEntity.setQuantidade( dto.getQuantidade() );
        productsEntity.setNome( dto.getNome() );
        productsEntity.setDescricaolink( dto.getDescricaolink() );
        productsEntity.setDescricaoCompleta( dto.getDescricaoCompleta() );
        productsEntity.setPreco( dto.getPreco() );

        return productsEntity;
    }

    @Override
    public ProdutoResponseDTO paraProdutoResponse(ProductsEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CategoriaResponseDTO categoria = null;
        List<String> imagens = null;
        int quantidade = 0;
        String nome = null;
        String descricaolink = null;
        String descricaoCompleta = null;
        BigDecimal preco = null;
        String slug = null;

        categoria = mapCategoriaResponse( entity.getCategoria() );
        imagens = mapImagensEntityToString( entity.getImagens() );
        quantidade = entity.getQuantidade();
        nome = entity.getNome();
        descricaolink = entity.getDescricaolink();
        descricaoCompleta = entity.getDescricaoCompleta();
        preco = entity.getPreco();
        slug = entity.getSlug();

        ProdutoResponseDTO produtoResponseDTO = new ProdutoResponseDTO( nome, descricaolink, descricaoCompleta, preco, imagens, slug, categoria, quantidade );

        return produtoResponseDTO;
    }

    @Override
    public List<ProdutoResponseDTO> paraListarProdutoResponse(List<ProductsEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<ProdutoResponseDTO> list = new ArrayList<ProdutoResponseDTO>( entities.size() );
        for ( ProductsEntity productsEntity : entities ) {
            list.add( paraProdutoResponse( productsEntity ) );
        }

        return list;
    }
}
