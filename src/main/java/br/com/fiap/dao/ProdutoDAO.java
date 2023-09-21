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
	
	public List<Produto> buscarPorNomeEstabelecimento(String nome){
		return em.createQuery("from Produto p where p.estabelecimento.nome = :nome", Produto.class)
				.setParameter("nome", nome).getResultList();
	}
	
	public Produto buscarPorInstagram(String insta){
		return em.createQuery("from Produto p where p.estabelecimento.instagram = :insta", Produto.class)
				.setParameter("insta", insta).getSingleResult();
	}
	
	public long contar(){
		return em.createQuery("select count(p) from Produto p", Long.class)
				.getSingleResult();
	}
	
	public int atualizarValor(double antigoValor, double novoValor) {
		em.getTransaction().begin();
		int total = em.createQuery("update Produto p set p.preco = :novo where p.preco = :antigo")
				.setParameter("novo", novoValor).setParameter("antigo", antigoValor)
				.executeUpdate();
		em.getTransaction().commit();
		return total;
	}
	
	public int removerPorValor(double valor) {
		em.getTransaction().begin();
		int total = em.createQuery("delete Produto p where p.preco = :valor")
				.setParameter("valor", valor)
				.executeUpdate();
		em.getTransaction().commit();
		return total;
	}
	
}



