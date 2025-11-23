package Estoque.Business.dto.Request;

import java.math.BigDecimal;
import java.util.List;



public class ProdutoRequestDTO {



    private String nome;
    private String descricaolink;
    private String descricaoCompleta;
    private BigDecimal preco;
    private List<String> imagens;
    private Long categoriaId;
    private int quantidade;

    public ProdutoRequestDTO(String nome, String descricaolink, String descricaoCompleta, BigDecimal preco, List<String> imagens, Long categoriaId, int quantidade) {
        this.nome = nome;
        this.descricaolink = descricaolink;
        this.descricaoCompleta = descricaoCompleta;
        this.preco = preco;
        this.imagens = imagens;
        this.categoriaId = categoriaId;
        this.quantidade = quantidade;
    }



    public int getQuantidade() {return quantidade;
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

    public Long getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Long categoriaId) {
        this.categoriaId = categoriaId;
    }
}


