package br.com.fiap.dao;

import java.util.Calendar;
import java.util.List;

import br.com.fiap.entity.Produto;
import jakarta.persistence.EntityManager;

public class ProdutoDAO extends GenericDAO<Produto, Integer>{

	public ProdutoDAO(EntityManager em) {
		super(em);
	}

	public List<Produto> listarOrdenadoPorNome(int inicio, int maximo){
		return em.createQuery("from Produto p order by nome", Produto.class)
				.setFirstResult(inicio)
				.setMaxResults(maximo)
				.getResultList();
	}
	
	public List<Produto> buscarPorNome(String nome){
		return em.createQuery("from Produto p where p.nome like :nomeProduto ", Produto.class)
				.setParameter("nomeProduto", "%" + nome + "%").getResultList();
	}
	
	public List<Produto> buscarPorData(Calendar data){
		return em.createQuery("from Produto p where p.dataCadastro > :data ", Produto.class)
				.setParameter("data", data).getResultList();
	}
}
