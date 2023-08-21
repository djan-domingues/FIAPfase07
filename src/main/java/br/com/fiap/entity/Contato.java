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
@Table(name="tb_contato")
public class Contato {
	
	@Id
	@SequenceGenerator(name="contato", sequenceName="sq_tb_contato",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "contato")
	private int codigo;
	
	@Column(name="ds_email", nullable=false, length=40)
	private String emai;
	
	@Column(name="ds_telefone", nullable=false, length=13)
	private String telefone;
	
	@CreationTimestamp
	@Column(name="dt_cadastro") 
	private Calendar dataCadastro;
	
	@UpdateTimestamp
	@Column(name="dt_modificacao")
	private Calendar dataModificacao;

	public Contato() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contato(int codigo, String emai, String telefone, Calendar dataCadastro, Calendar dataModificacao) {
		super();
		this.codigo = codigo;
		this.emai = emai;
		this.telefone = telefone;
		this.dataCadastro = dataCadastro;
		this.dataModificacao = dataModificacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getEmai() {
		return emai;
	}

	public void setEmai(String emai) {
		this.emai = emai;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
