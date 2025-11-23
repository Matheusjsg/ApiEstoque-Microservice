package Estoque.Business.dto.Request;



public class CategoriaRequestDTO {
    private String nome;

    public String getNome() {
        return nome;
    }

    public CategoriaRequestDTO(String nome) {
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
