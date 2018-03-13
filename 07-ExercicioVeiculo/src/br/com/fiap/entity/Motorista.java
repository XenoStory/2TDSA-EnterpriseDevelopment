package br.com.fiap.entity;

import java.io.Serializable;
import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "T_MOTORISTA")
public class Motorista implements Serializable {
	
	@Id
	@Column(name = "nr_carteira", nullable = false)
	private int numeroCarteira;
	
	@Column(name = "nm_motorista", length = 150, nullable = false)
	private String nome;
	
	@Column(name = "dt_nascimento")
	@Temporal(TemporalType.DATE)
	private Calendar dtNascimento;
	
	@Lob
	@Column(name = "fl_carteira")
	private byte[] foto;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "ds_genero")
	private Genero genero;

	
	public Motorista() {
		super();
	}

	public Motorista( String nome, Calendar dtNascimento, byte[] foto, Genero genero) {
		super();
		this.nome = nome;
		this.dtNascimento = dtNascimento;
		this.foto = foto;
		this.genero = genero;
	}

	public int getNumeroCarteira() {
		return numeroCarteira;
	}

	public void setNumeroCarteira(int numeroCarteira) {
		this.numeroCarteira = numeroCarteira;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Calendar getDtNascimento() {
		return dtNascimento;
	}

	public void setDtNascimento(Calendar dtNascimento) {
		this.dtNascimento = dtNascimento;
	}

	public byte[] getFoto() {
		return foto;
	}

	public void setFoto(byte[] foto) {
		this.foto = foto;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	
	

}
