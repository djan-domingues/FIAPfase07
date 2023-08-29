package br.com.fiap.teste;

import br.com.fiap.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Teste {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("atividadeFIAPcap7");
		
		EntityManager em = fabrica.createEntityManager();
		
		Produto produto = new Produto();
		produto.setNome("Felipe");
		try {
			em.persist(produto);		
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception ex) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		Produto produtBusca = em.find(Produto.class, 1);
		
		System.out.println(produtBusca.getId() +" "+ produtBusca.getNome());
		
		
		
		try {	
			produtBusca.setNome("batata");
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception ex) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		System.out.println(produtBusca.getId() +" "+ produtBusca.getNome());
		
		try {	
			em.remove(produtBusca);
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception ex) {
			if(em.getTransaction().isActive()) {
				em.getTransaction().rollback();
			}
		}
		
		em.close();
		fabrica.close();
	}

}
