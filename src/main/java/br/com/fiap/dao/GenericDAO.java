package br.com.fiap.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import br.com.fiap.entity.Produto;
import jakarta.persistence.EntityManager;

public class GenericDAO <T, K> {

	protected EntityManager em;
	
	private Class<T> clazz;
	
	public GenericDAO(EntityManager em) {
		this.em = em;
		clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public void cadastrar(T entidade) {
		em.persist(entidade);
	}
	
	
	public void atualizar(T entidade) {
		em.merge(entidade); 
	}
	
	public T buscar(K chave) {
		return em.find(clazz, chave);
	}
	
	public List<T> listar(){
		return em.createQuery("from " + clazz.getName(),clazz)
				.getResultList();
	}
	
	public void remover(K chave) throws Exception{
		T entidade = buscar(chave);
		
		if(entidade == null) {
			throw new Exception("Entidade nao encontrada");
		}
		em.remove(entidade);
	}
	
	public void commit() throws Exception {
		try {
			em.getTransaction().begin();
			em.getTransaction().commit();
		}catch(Exception ex) {
			if(em.getTransaction().isActive()) 
				em.getTransaction().rollback();
			throw new Exception("Erro no commit");
			
		}
	}
}
