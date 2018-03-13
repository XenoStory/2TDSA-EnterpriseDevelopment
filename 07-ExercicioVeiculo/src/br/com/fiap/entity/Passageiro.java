package br.com.fiap.entity;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="T_PASSAGEIRO")
@SequenceGenerator(name="passageiro", sequenceName="SQ_T_PASSAGEIRO", allocationSize=1)
public class Passageiro 
{
	@Id
	@Column(name="cd_codigo")
	@GeneratedValue(generator="passageiro", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="ds_nome", nullable=false, length=120)
	private String nome;
	
	@Column(name="dt_nascimento")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar nascimento;
	
	@Column(name="ds_genero")
	private Genero genero;
	
	public Passageiro() {}
	
	public Passageiro(String nome, Calendar nascimento, Genero genero) 
	{
		this.nome = nome;
		this.nascimento = nascimento;
		this.genero = genero;
	}



	public int getCodigo() 
	{
		return codigo;
	}
	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}
	public String getNome() 
	{
		return nome;
	}
	public void setNome(String nome) 
	{
		this.nome = nome;
	}
	public Calendar getNascimento() 
	{
		return nascimento;
	}
	public void setNascimento(Calendar nascimento) 
	{
		this.nascimento = nascimento;
	}
	public Genero getGenero() 
	{
		return genero;
	}
	public void setGenero(Genero genero) 
	{
		this.genero = genero;
	}
	
	
}
