package br.com.fiap.jpa.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_PUBLICACAO")
@SequenceGenerator(name="pub",sequenceName="SQ_T_PUBLICACAO",allocationSize=1)
public class Publicacao {

	@Id
	@Column(name="cd_publicacao")
	@GeneratedValue(generator="pub",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_autor",nullable=false,length=50)
	private String autor;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="dt_publicacao",nullable=false)
	private Calendar dataPublicacao;
	
	@Lob
	@Column(name="fl_imagem")
	private byte[] imagem;
	
	@Column(name="ds_conteudo",nullable=false,length=250)
	private String conteudo;
	
	@Column(name="nr_curtida")
	private int curtidas;
	
	@Column(name="ds_privacidade",nullable=false)
	private PrivacidadePublicacao privacidade;
	
	public Publicacao() {
		super();
	}

	public Publicacao(String autor, Calendar dataPublicacao, byte[] imagem, String conteudo, int curtidas,
			PrivacidadePublicacao privacidade) {
		super();
		this.autor = autor;
		this.dataPublicacao = dataPublicacao;
		this.imagem = imagem;
		this.conteudo = conteudo;
		this.curtidas = curtidas;
		this.privacidade = privacidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public Calendar getDataPublicacao() {
		return dataPublicacao;
	}

	public void setDataPublicacao(Calendar dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public int getCurtidas() {
		return curtidas;
	}

	public void setCurtidas(int curtidas) {
		this.curtidas = curtidas;
	}

	public PrivacidadePublicacao getPrivacidade() {
		return privacidade;
	}

	public void setPrivacidade(PrivacidadePublicacao privacidade) {
		this.privacidade = privacidade;
	}
	
}
