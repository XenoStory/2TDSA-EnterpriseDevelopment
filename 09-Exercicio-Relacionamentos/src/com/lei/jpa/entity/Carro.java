package com.lei.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_CARRO")
public class Carro 
{
	@Id
	@Column(name="nr_revanam")
	private int revanam;
	
	@Column(name="ds_cor", nullable=false)
	private String cor;
	
	@Column(name="nr_ano", nullable=false)
	private int ano;

	@OneToOne(mappedBy="carro", cascade=CascadeType.PERSIST)
	private Placa placa;
	
	public Carro() {}
	
	public Carro(int revanam, String cor, int ano)
	{
		this.revanam = revanam;
		this.cor = cor;
		this.ano = ano;
	}
	
	public int getRevanam() 
	{
		return revanam;
	}

	public void setRevanam(int revanam) 
	{
		this.revanam = revanam;
	}

	public String getCor() 
	{
		return cor;
	}

	public void setCor(String cor) 
	{
		this.cor = cor;
	}

	public int getAno() 
	{
		return ano;
	}

	public void setAno(int ano) 
	{
		this.ano = ano;
	}

	public Placa getPlaca() 
	{
		return placa;
	}

	public void setPlaca(Placa placa) 
	{
		this.placa = placa;
	}
	
	
}
