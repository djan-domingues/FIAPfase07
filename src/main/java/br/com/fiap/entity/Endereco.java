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
@Table(name="tb_endereco")
public class Endereco {
	
	@Id
	@SequenceGenerator(name="codigo", sequenceName="sq_tb_codigo",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "codigo")
	@Column(name="cd_codigo")
	private int codigo;
	
	@Column(name="nm_logradouro", nullable=false, length=60)
	private String logradouro;
	
	@Column(name="ds_numero", nullable=false)
	private int numero;
	
	@Column(name="ds_complemento", nullable=true, length=40)
	private String complemento;
	
	@Column(name="ds_cep", nullable=false, length=9)
	private String cep;
	
	@CreationTimestamp
	@Column(name="dt_cadastro")
	private Calendar dataCadastro;
	
	@UpdateTimestamp
	@Column(name="dt_modificacao")
	private Calendar dataModificacao;

	public Endereco() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Endereco(int codigo, String logradouro, int numero, String complemento, String cep, Calendar dataCadastro,
			Calendar dataModificacao) {
		super();
		this.codigo = codigo;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.cep = cep;
		this.dataCadastro = dataCadastro;
		this.dataModificacao = dataModificacao;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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
