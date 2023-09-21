package br.com.fiap.entity;

import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_produto")
public class Produto {

	@Id
	@SequenceGenerator(name="produto", sequenceName="sq_tb_produto",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "produto")
	@Column(name="cd_produto")
	private int id;

	@Column(name="nm_produto", nullable=false, length=40)
	private String nome;
	
	@Column(name="vl_preco")
	private double preco;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_estabelecimento")
	private Estabelecimento estabelecimento;
	
	@Column(name="dt_cadastro")
	@CreationTimestamp
	private Calendar dataCadastro;
	
	@Column(name="dt_modificacao")
	@UpdateTimestamp
	private Calendar dataModificacao;
	
	
	
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Produto(int id, String nome, double preco, Tipo tipo, Estabelecimento estabelecimento) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.tipo = tipo;
		this.estabelecimento = estabelecimento;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getNome() {
		return nome;
	}



	public void setNome(String nome) {
		this.nome = nome;
	}



	public double getPreco() {
		return preco;
	}



	public void setPreco(double preco) {
		this.preco = preco;
	}



	public Tipo getTipo() {
		return tipo;
	}



	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}



	public Estabelecimento getEstabelecimento() {
		return estabelecimento;
	}



	public void setEstabelecimento(Estabelecimento estabelecimento) {
		this.estabelecimento = estabelecimento;
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

	
	

}
	

