package dao;

import model.Produto;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoDAO {

    // O "jpa_exemplo" é o nome de persistência configurada no persistence.xml
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa_exemplo");

    // Método pra salvar um produto no banco
    public void criar(Produto produto) {
        EntityManager em = emf.createEntityManager(); // Gerenciador de entidades
        em.getTransaction().begin(); // Começa uma transação
        em.persist(produto); // Adiciona o produto ao banco
        em.getTransaction().commit(); // Finaliza a transação
        em.close(); // Fecha o gerenciador
    }

    // Método pra buscar um produto pelo ID
    public Produto ler(Long id) {
        EntityManager em = emf.createEntityManager(); // Cria o gerenciador
        Produto produto = em.find(Produto.class, id); // Busca o produto pela chave primária
        em.close(); // Fecha o gerenciador
        return produto; // Retorna o produto encontrado
    }

    // Método pra listar todos os produtos cadastrados no banco
    public List<Produto> listarTodos() {
        EntityManager em = emf.createEntityManager(); // Cria o gerenciador
        // Query pra buscar todos os produtos
        List<Produto> produtos = em.createQuery("FROM Produto", Produto.class).getResultList();
        em.close(); // Fecha o gerenciador
        return produtos; // Retorna a lista de produtos
    }

    // Método pra atualizar as informações de um produto
    public void atualizar(Produto produto) {
        EntityManager em = emf.createEntityManager(); // Cria o gerenciador
        em.getTransaction().begin(); // Começa uma transação
        em.merge(produto); // Atualiza o produto no banco
        em.getTransaction().commit(); // Finaliza a transação
        em.close(); // Fecha o gerenciador
    }

    // Método pra deletar um produto pelo ID
    public void excluir(Long id) {
        EntityManager em = emf.createEntityManager(); // Cria o gerenciador
        Produto produto = em.find(Produto.class, id); // Busca o produto pelo ID
        if (produto != null) { // Se encontrou o produto...
            em.getTransaction().begin(); // Começa uma transação
            em.remove(produto); // Remove o produto do banco
            em.getTransaction().commit(); // Finaliza a transação
        }
        em.close(); // Fecha o gerenciador
    }
}
