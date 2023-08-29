package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_fornecedor")
public class Fornecedor {

	@Id
	@SequenceGenerator(name="fornecedor", sequenceName="sq_tb_fornecedor",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "fornecedor")
	@Column(name="cd_fornecedor")
	private int codigo;
	
	@Column(name="nm_fornecedor", nullable=false, length=40)
	private String nome;
	
	@CreationTimestamp
	@Column(name="dt_cadastro")
	private Calendar dataCadastro;
	
	@UpdateTimestamp
	@Column(name="dt_modificacao")
	private Calendar dataModificacao;
	
	@OneToOne
	private Contato contato;
	
	@OneToOne
	private Endereco endereco;
	
	@OneToMany
	private List<Produto> produtos;
	
	@ManyToMany(mappedBy = "fornecedores")
	private List<Loja> lojas;
	
	public Fornecedor() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Fornecedor(int codigo, String nome, Calendar dataCadastro, Calendar dataModificacao, Contato contato,
			Endereco endereco,  List<Loja> lojas, List<Produto> produtos) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.dataModificacao = dataModificacao;
		this.contato = contato;
		this.lojas = lojas;
		this.produtos = produtos;
		this.endereco = endereco;
	}



	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Calendar getDataModificacao() {
		return dataModificacao;
	}

	public void setDataModificacao(Calendar dataModificacao) {
		this.dataModificacao = dataModificacao;
	}



	public Contato getContato() {
		return contato;
	}



	public void setContato(Contato contato) {
		this.contato = contato;
	}



	public Endereco getEndereco() {
		return endereco;
	}



	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	public List<Produto> getProduto() {
		return produtos;
	}

	public void setProduto(List<Produto> produtos) {
		this.produtos = produtos;
	}



	public List<Loja> getLoja() {
		return lojas;
	}



	public void setLoja(List<Loja> lojas) {
		this.lojas = lojas;
	}
	
	

}
