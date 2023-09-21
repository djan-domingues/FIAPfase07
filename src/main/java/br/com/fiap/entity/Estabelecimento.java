package br.com.fiap.entity;

import java.io.Serializable;
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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_estabelecimento")
public class Estabelecimento implements Serializable{

	private static final long serialVersionUID = -2894919065438801688L;

	@Id
	@SequenceGenerator(name="estabelecimento", sequenceName="sq_tb_estabelecimento",allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "estabelecimento")
	@Column(name="cd_estabelecimento")
	private int codigo;
	
	@Column(name="nm_estabelecimento", nullable=false, length=40)
	private String nome;
	
	@Column(name="ds_endereco", nullable=false, length=40)
	private String endereco;
	
	@Column(name="ds_estabelecimento", nullable=false, length=40)
	private String descricao;
	
	@Column(name="ds_telefone", nullable=false, length=40)
	private String telefone;
	
	@Column(name="ds_email", nullable=false, length=40)
	private String email;
	
	@Column(name="ds_instagram", nullable=false, length=40)
	private String instagram;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "cd_categoria_estabelecimento")
	private Categoria categoria;
	
	@OneToMany
	private List<Produto> produtos;
	
	@Column(name="dt_cadastro")
	@CreationTimestamp
	private Calendar dataCadastro;
	
	@Column(name="dt_modificacao")
	@UpdateTimestamp
	private Calendar dataModificacao;

	public Estabelecimento() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Estabelecimento(int codigo, String nome, String endereco, String descricao, String telefone, String email,
			String instagram, Categoria categoria) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.endereco = endereco;
		this.descricao = descricao;
		this.telefone = telefone;
		this.email = email;
		this.instagram = instagram;
		this.categoria = categoria;
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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	
	
	
}
