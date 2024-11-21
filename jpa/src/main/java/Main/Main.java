package Main;

import dao.ProdutoDAO;
import model.Produto;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
    	
        // Criando uma instância do DAO pra salvar e buscar produtos no banco
        ProdutoDAO produtoDAO = new ProdutoDAO();
        
        // Scanner pra ler as entradas do usuário
        Scanner scanner = new Scanner(System.in);

        // Variável pra controlar se o usuário quer continuar cadastrando produtos
        String continuar = "sim";
        while (continuar.equalsIgnoreCase("sim")) { // Continua enquanto o usuário responder "sim"
            
            Produto produto = new Produto(); // Criando um novo produto e pedindo os dados dele
            System.out.print("Digite o nome do produto: ");
            produto.setNome(scanner.nextLine()); // Lê o nome do produto

            System.out.print("Digite o preço do produto: ");
            produto.setPreco(scanner.nextDouble()); // Lê o preço do produto
            scanner.nextLine();

            produtoDAO.criar(produto);// Adiciona o produto ao banco

            // Pergunta se o usuário quer cadastrar outro produto
            System.out.print("Deseja adicionar outro produto? (sim/não): ");
            continuar = scanner.nextLine(); // Lê a resposta
        }

        // Depois que o usuário terminar, lista todos os produtos cadastrados no banco
        System.out.println("Lista de produtos no banco de dados:");
        produtoDAO.listarTodos() // Pega a lista de produtos do banco
            .forEach(p -> System.out.println(p.getNome() + " - " + p.getPreco())); // Mostra o nome e o preço de cada produto

        // Fecha o Scanner pra evitar vazamento de recursos
        scanner.close();
    }
}
