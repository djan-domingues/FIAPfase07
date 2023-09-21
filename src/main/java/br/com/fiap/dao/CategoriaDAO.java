package br.com.fiap.dao;

import br.com.fiap.entity.Categoria;
import jakarta.persistence.EntityManager;

public class CategoriaDAO extends GenericDAO<Categoria, Integer>{

	public CategoriaDAO(EntityManager em) {
		super(em);
	}

}
