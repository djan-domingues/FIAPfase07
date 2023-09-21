package br.com.fiap.service;

import java.rmi.RemoteException;
import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class ProdutoServiceImpl implements ProdutoService {

	@Override
	public Produto buscar(int id) throws RemoteException {
		EntityManager em = Persistence.createEntityManagerFactory("atividadeFIAPfase2-2").createEntityManager();
		
		ProdutoDAO dao =  new ProdutoDAO(em);
		
		return dao.buscar(id);
	}

}
