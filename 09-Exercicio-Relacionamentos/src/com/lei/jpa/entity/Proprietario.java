package com.lei.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PROPRIETARIO")
@SequenceGenerator(name="proprietario", sequenceName="SQ_T_PROPRIETARIO", allocationSize=1)	
public class Proprietario 
{
	@Id
	@Column(name="cd_proprietario")
	@GeneratedValue(generator="proprietario", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_proprietario", nullable=false)
	private String nome;

	public Proprietario() {}
	
	public Proprietario(String nome)
	{
		this.nome = nome;
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
	
	
}
