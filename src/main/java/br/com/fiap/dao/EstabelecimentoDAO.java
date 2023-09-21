package br.com.fiap.dao;

import br.com.fiap.entity.Estabelecimento;
import jakarta.persistence.EntityManager;

public class EstabelecimentoDAO extends GenericDAO<Estabelecimento, Integer> {

	public EstabelecimentoDAO(EntityManager em) {
		super(em);
	}

}
