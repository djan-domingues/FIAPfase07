package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Contato;
import br.com.fiap.entity.Endereco;
import br.com.fiap.entity.Estado;
import br.com.fiap.entity.Loja;
import br.com.fiap.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Cadastro {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("atividadeFIAPcap7");
		
		EntityManager em = fabrica.createEntityManager();
		
		Endereco endereco01 = new Endereco(0, "rua 1", 1, "apt 1", "1111111", null, null);
		
		Contato contato01 = new Contato(0, "email@email.com", "111111111", null, null);		
		
		Produto produto01 = new Produto(0, "cerveja", 20, null, Estado.NOVO, null, null, 0);
		Produto produto02 = new Produto(0, "cerveja", 20, null, Estado.NOVO, null, null, 0);
		
		List<Produto> produtos = new ArrayList<>();
		produtos.add(produto01);
		produtos.add(produto02);
		
		Loja loja = new Loja(0, "loja", null, null, contato01, endereco01, produtos, null);
		
		em.persist(loja);
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
		fabrica.close();

	}

}
