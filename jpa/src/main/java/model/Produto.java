package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// Essa classe é a "cara" do produto no banco. Tudo que você definir aqui vai virar coluna.
@Entity // Fala que a classe é uma entidade do banco
public class Produto {

    @Id // Isso aqui é a chave primária 
    @GeneratedValue(strategy = GenerationType.IDENTITY) // O banco vai gerar os IDs automaticamente
    private Long id;

    private String nome; // Aqui vai o nome do produto 
    private Double preco; // E aqui o preço dele 

    //getters e setters

    public Long getId() {
        return id; // Serve pra pegar o ID do produto
    }

    public void setId(Long id) {
        this.id = id; // Serve pra definir o ID (normalmente o banco faz isso sozinho)
    }

    public String getNome() {
        return nome; // Pega o nome do produto
    }

    public void setNome(String nome) {
        this.nome = nome; // Altera o nome do produto
    }

    public Double getPreco() {
        return preco; // Pega o preço do produto
    }

    public void setPreco(Double preco) {
        this.preco = preco; // Altera o preço do produto
    }
}
