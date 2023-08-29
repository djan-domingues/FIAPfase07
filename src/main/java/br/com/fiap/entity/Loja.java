package br.com.fiap.entity;

import java.util.Calendar;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_loja")
public class Loja {
	
	@Id
	@SequenceGenerator(name="loja", sequenceName="sq_tb_loja",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "loja")
	@Column(name="cd_loja")
	private int codigo;
	
	@Column(name="nm_fornecedor", nullable=false, length=40)
	private String nome;
	
	@CreationTimestamp
	@Column(name="dt_cadastro")
	private Calendar dataCadastro;
	
	@UpdateTimestamp
	@Column(name="dt_modificacao")
	private Calendar dataModificacao;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Contato contato;
	
	@OneToOne(cascade = CascadeType.PERSIST)
	private Endereco endereco;
	
	@OneToMany(cascade = CascadeType.PERSIST)
	private List<Produto> produtos;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(joinColumns = @JoinColumn(name = "cd_loja"), inverseJoinColumns = @JoinColumn(name = "cd_fornecedor"), name="tb_pedido")
	private List<Fornecedor> fornecedores;

	public Loja() {
		super();
		// TODO Auto-generated constructor stub
	}	

	public Loja(int codigo, String nome, Calendar dataCadastro, Calendar dataModificacao, Contato contato,
			Endereco endereco, List<Produto> produtos, List<Fornecedor> fornecedores) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.dataModificacao = dataModificacao;
		this.contato = contato;
		this.endereco = endereco;
		this.produtos = produtos;
		this.fornecedores = fornecedores;
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

	public List<Fornecedor> getFornecedor() {
		return fornecedores;
	}

	public void setFornecedor(List<Fornecedor> fornecedor) {
		this.fornecedores = fornecedor;
	}
	
	

}
