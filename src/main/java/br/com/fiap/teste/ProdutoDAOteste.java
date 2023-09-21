package br.com.fiap.teste;

import java.util.List;

import br.com.fiap.dao.ProdutoDAO;
import br.com.fiap.entity.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class ProdutoDAOteste {
	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("atividadeFIAPfase2-2");
		
		EntityManager em = fabrica.createEntityManager();
		
		ProdutoDAO dao = new ProdutoDAO(em);
		
		//List<Produto> lista = dao.buscarPorData(new GregorianCalendar(2023, Calendar.SEPTEMBER, 20));
		
//		List<Produto> lista = dao.buscarPorNomeEstabelecimento("perus");
		
		int qt = dao.atualizarValor(30.00, 40.00);
		
//		for(Produto produto : lista) {
//			System.out.println(produto.getNome());
//		} 
		
		System.out.println(qt);
		
		em.close();
		fabrica.close();
	}

}
