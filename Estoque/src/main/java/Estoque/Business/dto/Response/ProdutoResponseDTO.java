package Estoque.Business.dto.Response;

import java.math.BigDecimal;
import java.util.List;


public class ProdutoResponseDTO {


        private String nome;
        private String descricaolink;
        private String descricaoCompleta;
        private BigDecimal preco;
        private List<String> imagens;
        private String slug;
        private CategoriaResponseDTO categoria;
        private int quantidade;


    public ProdutoResponseDTO(String nome, String descricaolink, String descricaoCompleta, BigDecimal preco, List<String> imagens, String slug, CategoriaResponseDTO categoria, int quantidade) {
        this.nome = nome;
        this.descricaolink = descricaolink;
        this.descricaoCompleta = descricaoCompleta;
        this.preco = preco;
        this.imagens = imagens;
        this.slug = slug;
        this.categoria = categoria;
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricaolink() {
        return descricaolink;
    }

    public void setDescricaolink(String descricaolink) {
        this.descricaolink = descricaolink;
    }

    public String getDescricaoCompleta() {
        return descricaoCompleta;
    }

    public void setDescricaoCompleta(String descricaoCompleta) {
        this.descricaoCompleta = descricaoCompleta;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public List<String> getImagens() {
        return imagens;
    }

    public void setImagens(List<String> imagens) {
        this.imagens = imagens;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public CategoriaResponseDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaResponseDTO categoria) {
        this.categoria = categoria;
    }


}

