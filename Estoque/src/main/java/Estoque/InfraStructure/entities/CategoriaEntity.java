package Estoque.InfraStructure.entities;


import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name = "categorias")
public class CategoriaEntity {


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;

        @OneToMany(mappedBy = "categoria")
        private List<ProductsEntity> produtos;

        public CategoriaEntity() {
        }

    public CategoriaEntity(Long id, String nome, List<ProductsEntity> produtos) {
        this.id = id;
        this.nome = nome;
        this.produtos = produtos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ProductsEntity> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<ProductsEntity> produtos) {
        this.produtos = produtos;
    }
}
