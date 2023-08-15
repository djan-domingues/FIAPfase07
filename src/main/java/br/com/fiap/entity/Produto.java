package br.com.fiap.entity;

import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

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
	
	@Temporal(TemporalType.DATE)
	@Column(name="dt_data_validade")
	private Calendar dataValidade;
	
	@Enumerated(EnumType.STRING)
	private Estado estado;
	
	@Column(name="dt_cadastro")
	@CreationTimestamp
	private Calendar dataCadastro;
	
	@Column(name="dt_modificacao")
	@UpdateTimestamp
	private Calendar dataModificacao;
	
	@Formula("vl_preco*0.9")
	private double precoDesconto;
	
	
	
	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(int id, String nome, double preco, Calendar dataValidade, Estado estado, Calendar dataCadastro,
			Calendar dataModificacao, double precoDesconto) {
		super();
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.dataValidade = dataValidade;
		this.estado = estado;
		this.dataCadastro = dataCadastro;
		this.dataModificacao = dataModificacao;
		this.precoDesconto = precoDesconto;
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

	public Calendar getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Calendar dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
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

	public double getPrecoDesconto() {
		return precoDesconto;
	}

	public void setPrecoDesconto(double precoDesconto) {
		this.precoDesconto = precoDesconto;
	}
	
}
