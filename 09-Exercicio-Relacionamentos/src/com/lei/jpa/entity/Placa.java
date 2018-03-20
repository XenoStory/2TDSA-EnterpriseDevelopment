package com.lei.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_PLACA")
@SequenceGenerator(name="placa", sequenceName="SQ_T_PLACA", allocationSize=1)
public class Placa 
{
	@Id
	@Column(name="cd_placa")
	@GeneratedValue(generator="placa", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nr_placa", nullable=false)
	private String placa;
	
	@Column(name="ds_pais", nullable=false)
	private Pais pais;
	
	@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_placa")
	private Carro carro;
	
	public Placa() {}
	
	public Placa(String placa, Pais pais)
	{
		this.placa = placa;
		this.pais = pais;
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}

	public String getPlaca() 
	{
		return placa;
	}

	public void setPlaca(String placa) 
	{
		this.placa = placa;
	}

	public Pais getPais() 
	{
		return pais;
	}

	public void setPais(Pais pais) 
	{
		this.pais = pais;
	}

	public Carro getCarro() 
	{
		return carro;
	}

	public void setCarro(Carro carro) 
	{
		this.carro = carro;
	}
	
	
	
	
}
