package br.com.fiap.entity;

import java.util.Calendar;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

	public Loja() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Loja(int codigo, String nome, Calendar dataCadastro, Calendar dataModificacao) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.dataCadastro = dataCadastro;
		this.dataModificacao = dataModificacao;
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
	
	

}
