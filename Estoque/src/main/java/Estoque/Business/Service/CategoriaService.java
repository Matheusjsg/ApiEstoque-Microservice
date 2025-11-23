package Estoque.Business.Service;


import Estoque.Business.MapStruct.CategoriaMapper;
import Estoque.Business.dto.Request.CategoriaRequestDTO;
import Estoque.Business.dto.Response.CategoriaResponseDTO;
import Estoque.InfraStructure.entities.CategoriaEntity;
import Estoque.InfraStructure.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public CategoriaService(CategoriaRepository categoriaRepository, CategoriaMapper categoriaMapper) {
        this.categoriaRepository = categoriaRepository;
        this.categoriaMapper = categoriaMapper;
    }

    public CategoriaResponseDTO CriarCategoria (CategoriaRequestDTO categoriaDto){
        // Transformar DTO em Entity
        CategoriaEntity categoria = categoriaMapper.toEntity(categoriaDto);

        // Salvar no banco
        CategoriaEntity salvo = categoriaRepository.save(categoria);

        // Retornar DTO de resposta
        return categoriaMapper.toResponse(salvo);
    }

}
