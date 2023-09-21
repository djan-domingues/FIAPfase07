package br.com.fiap.service;

import java.rmi.RemoteException;

import br.com.fiap.dao.EstabelecimentoDAO;
import br.com.fiap.entity.Estabelecimento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class EstabelecimentoServiceImpl implements EstabelecimentoService {

	@Override
	public Estabelecimento buscar(int id) throws RemoteException {
		
		EntityManager em = Persistence.createEntityManagerFactory("atividadeFIAPfase2-2").createEntityManager();
		
		EstabelecimentoDAO dao =  new EstabelecimentoDAO(em);
		
		return dao.buscar(id);
	}

}
