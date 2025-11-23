package Estoque.Business.Service;

import Estoque.Business.MapStruct.ProdutoMapper;
import Estoque.Business.dto.Request.ProdutoRequestDTO;
import Estoque.Business.dto.Response.ProdutoResponseDTO;
import Estoque.InfraStructure.entities.CategoriaEntity;
import Estoque.InfraStructure.entities.ImagemEntity;
import Estoque.InfraStructure.entities.ProductsEntity;
import Estoque.InfraStructure.repositories.CategoriaRepository;
import Estoque.InfraStructure.repositories.ProductsRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.Normalizer;
import java.util.List;
import java.util.Locale;


@Service
public class ProdutoService {

    public ProdutoService(ProductsRepository produtoRepository, CategoriaRepository categoriaRepository, ProdutoMapper produtoMapper) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.produtoMapper = produtoMapper;
    }

    private final ProductsRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final ProdutoMapper produtoMapper;


    @Transactional
    public ProdutoResponseDTO criarProduto(ProdutoRequestDTO dto) {

        // Transformar DTO em Entity
        ProductsEntity produto = produtoMapper.paraProdutoEntity(dto);

        // 2️⃣ Buscar categoria pelo ID
        CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
        produto.setCategoria(categoria);

        // 3️⃣ Gerar slug automaticamente a partir do nome
        produto.setSlug(gerarSlug(produto.getNome()));

        // 4️⃣ Associar produto às imagens (já mapeado pelo mapper)
        produto.getImagens().forEach(img -> img.setProduto(produto));

        produto.setQuantidade(produto.getQuantidade());

        // 5️⃣ Salvar no banco
        ProductsEntity salvo = produtoRepository.save(produto);

        // 6️⃣ Retornar DTO de resposta
        return produtoMapper.paraProdutoResponse(salvo);
    }

    // -------- Listar todos os produtos --------
    public List<ProdutoResponseDTO> listarProdutos() {
        List<ProductsEntity> produtos = produtoRepository.findAll();
        return produtoMapper.paraListarProdutoResponse(produtos);
    }

    public List<ProdutoResponseDTO> listarProdutosCategotia(String nome) {
        List<ProductsEntity> produtos = produtoRepository.findByCategoria_NomeIgnoreCase(nome);
        return produtoMapper.paraListarProdutoResponse(produtos);

    }


    // -------- Buscar produto por ID --------
    public ProdutoResponseDTO buscarProdutoPorId(Long id) {
        ProductsEntity produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
        return produtoMapper.paraProdutoResponse(produto);
    }

    @Transactional
    public ProdutoResponseDTO editarProduto(Long id, ProdutoRequestDTO dto) {
        // 1️⃣ Buscar produto existente
        ProductsEntity produto = produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

        // 2️⃣ Atualizar campos básicos
        produto.setNome(dto.getNome());
        produto.setDescricaolink(dto.getDescricaolink());
        produto.setDescricaoCompleta(dto.getDescricaoCompleta());
        produto.setQuantidade(dto.getQuantidade());
        produto.setPreco(dto.getPreco());

        // 3️⃣ Atualizar slug se o nome mudou
        if (dto.getNome() != null && !dto.getNome().equals(produto.getNome())) {
            produto.setSlug(gerarSlug(dto.getNome()));
        }

        // 4️⃣ Atualizar categoria, se enviada
        if (dto.getCategoriaId() != null) {
            CategoriaEntity categoria = categoriaRepository.findById(dto.getCategoriaId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            produto.setCategoria(categoria);
        }

        // 5️⃣ Atualizar imagens
        if (dto.getImagens() != null && !dto.getImagens().isEmpty()) {
            produto.getImagens().clear(); // remove imagens antigas
            dto.getImagens().forEach(url -> {
                var imagem = new ImagemEntity();
                imagem.setNomeArquivo(url);
                imagem.setProduto(produto);
                produto.getImagens().add(imagem);
            });
        }

        // 6️⃣ Salvar produto atualizado
        ProductsEntity atualizado = produtoRepository.save(produto);

        // 7️⃣ Retornar DTO de resposta
        return produtoMapper.paraProdutoResponse(atualizado);
    }

    public void deletarProdutoPorId(Long id){
                produtoRepository.deleteById(id);
    }


    // -------- Gerar slug a partir do nome --------
    private String gerarSlug(String nome) {
        if (nome == null) return null;
        // Remove acentos e caracteres especiais
        String slug = Normalizer.normalize(nome, Normalizer.Form.NFD)
                .replaceAll("[^\\p{ASCII}]", "")
                .toLowerCase(Locale.ROOT)
                .replaceAll("[^a-z0-9]+", "-")
                .replaceAll("^-|-$", ""); // remove "-" no começo/fim
        return slug;
    }



}
