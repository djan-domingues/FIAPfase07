package br.com.fiap.service;

import java.rmi.RemoteException;

import br.com.fiap.dao.CategoriaDAO;
import br.com.fiap.entity.Categoria;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class CategoriaServiceImpl implements CategoriaService {

	@Override
	public Categoria buscar(int id) throws RemoteException {
	
		EntityManager em = Persistence.createEntityManagerFactory("atividadeFIAPfase2-2").createEntityManager();
		
		CategoriaDAO dao =  new CategoriaDAO(em);
		
		return dao.buscar(id);
	}

}
