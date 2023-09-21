package br.com.fiap.teste;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.entity.Categoria;
import br.com.fiap.entity.Estabelecimento;
import br.com.fiap.entity.Produto;
import br.com.fiap.entity.Tipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Cadastro {

	public static void main(String[] args) {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("atividadeFIAPfase2-2");
		
		List<Categoria> categorias = new ArrayList<>();
		List<Estabelecimento> estabelecimentos = new ArrayList<>();
		List<Produto> produtos = new ArrayList<>();
		
		EntityManager em = fabrica.createEntityManager();
			
		Categoria categoria01 = new Categoria(0, "Italiano", "Massas e Pizzas");
		Categoria categoria02 = new Categoria(0, "Arabe", "Khebabs, Kibes, Esfihas e Zatar");
		Categoria categoria03 = new Categoria(0, "Peruana", "Seviche e Caldos");
		Categoria categoria04 = new Categoria(0, "Argentina", "Empanadas e sobreassadas");
		Categoria categoria05 = new Categoria(0, "Brasileira", "Feijoada e Feijao tropeiro");
		
		em.persist(categoria01);
		em.persist(categoria02);
		em.persist(categoria03);
		em.persist(categoria04);
		em.persist(categoria05);
		
		Estabelecimento estabelecimento01 = new Estabelecimento(0, "Palermo", "Rua italia 4", "belissimo restaurante", "1195959595", "palermo@gmail.com", "@palermo", categoria01 );
		Estabelecimento estabelecimento02 = new Estabelecimento(0, "Latio", "Rua italiana 4", "lindissimo restaurante", "11978787878", "latio@gmail.com", "@latio", categoria01 );	
		Estabelecimento estabelecimento03 = new Estabelecimento(0, "mohamed", "Rua arabia 4", "gostosissimo restaurante", "11947474747", "mohamed@gmail.com", "@pmohamed", categoria02 );
		Estabelecimento estabelecimento04 = new Estabelecimento(0, "mustafah", "Rua arabiana 4", "legalissimo restaurante", "11923232332", "mustafah@gmail.com", "@mustafah", categoria02 );
		Estabelecimento estabelecimento05 = new Estabelecimento(0, "perus", "Rua peru 4", "extraordinario restaurante", "111956565656", "perus@gmail.com", "@perus", categoria03 );
		Estabelecimento estabelecimento06 = new Estabelecimento(0, "jassira", "Rua jassira 4", "bombbastico restaurante", "11963636363", "jassira@gmail.com", "@jassira", categoria03 );
		Estabelecimento estabelecimento07 = new Estabelecimento(0, "miguelito", "Rua argentina 4", "indescritivel restaurante", "11942424242", "miguelito@gmail.com", "@miguelito", categoria04 );
		Estabelecimento estabelecimento08 = new Estabelecimento(0, "juarez", "Rua juarez 4", "tradicionalissimo restaurante", "1195959595", "juarez@gmail.com", "@juarez", categoria04 );
		Estabelecimento estabelecimento09 = new Estabelecimento(0, "Point do gordao", "Rua gordo 4", "deliciosissimo restaurante", "1177777777", "gordao@gmail.com", "@gordao", categoria05 );
		Estabelecimento estabelecimento10 = new Estabelecimento(0, "bololo", "Rua bololo 4", "bololo restaurante", "1103030330", "bololo@gmail.com", "@bololo", categoria05 );
		
		em.persist(estabelecimento10);		
		em.persist(estabelecimento09);	
		em.persist(estabelecimento08);	
		em.persist(estabelecimento07);	
		em.persist(estabelecimento06);	
		em.persist(estabelecimento05);	
		em.persist(estabelecimento04);	
		em.persist(estabelecimento03);	
		em.persist(estabelecimento02);	
		em.persist(estabelecimento01);	
		
		Produto produto01 = new Produto(0, "produto italiano", 30.00, Tipo.TIPO1, estabelecimento01 );
		Produto produto02 = new Produto(0, "produto italiano", 30.00, Tipo.TIPO3, estabelecimento01 );
		Produto produto03 = new Produto(0, "produto italiano", 30.00, Tipo.TIPO1, estabelecimento02 );
		Produto produto04 = new Produto(0, "produto Arabe", 30.00, Tipo.TIPO2, estabelecimento03 );
		Produto produto05 = new Produto(0, "produto Arabe", 30.00, Tipo.TIPO4, estabelecimento03 );
		Produto produto06 = new Produto(0, "produto Arabe", 30.00, Tipo.TIPO2, estabelecimento04 );
		Produto produto07 = new Produto(0, "produto Peruana", 30.00, Tipo.TIPO3, estabelecimento05 );
		Produto produto08 = new Produto(0, "produto Peruana", 30.00, Tipo.TIPO4, estabelecimento05 );
		Produto produto09 = new Produto(0, "produto Peruana", 30.00, Tipo.TIPO1, estabelecimento06 );
		Produto produto10 = new Produto(0, "produto Argentina", 30.00, Tipo.TIPO2, estabelecimento07 );
		Produto produto11 = new Produto(0, "produto Argentina", 30.00, Tipo.TIPO1, estabelecimento07 );
		Produto produto12 = new Produto(0, "produto Argentina", 30.00, Tipo.TIPO4, estabelecimento08 );
		Produto produto13 = new Produto(0, "produto Brasileira", 30.00, Tipo.TIPO3, estabelecimento09 );
		Produto produto14 = new Produto(0, "produto Brasileira", 30.00, Tipo.TIPO1, estabelecimento09 );
		Produto produto15 = new Produto(0, "produto Brasileira", 30.00, Tipo.TIPO2, estabelecimento10 );
		
		em.persist(produto15);
		em.persist(produto14);
		em.persist(produto13);
		em.persist(produto12);
		em.persist(produto11);
		em.persist(produto10);
		em.persist(produto09);
		em.persist(produto08);
		em.persist(produto07);
		em.persist(produto06);
		em.persist(produto05);
		em.persist(produto04);
		em.persist(produto03);
		em.persist(produto02);
		em.persist(produto01);
		
		em.getTransaction().begin();
		em.getTransaction().commit();
		em.close();
		fabrica.close();

	}

}
