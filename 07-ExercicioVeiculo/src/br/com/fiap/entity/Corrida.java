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
@Table(name="T_CORRIDA")
@SequenceGenerator(name="corrida", sequenceName="SQ_T_CORRIDA", allocationSize=1)
public class Corrida 
{
	@Id
	@GeneratedValue(generator="corrida", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_corrida")
	private int codigo;
	
	@Column(name="ds_origem", length=150)
	private String origem;
	
	@Column(name="ds_destino", length=150)
	private String destino;
	
	@Column(name="dt_corrida")
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar data;
	
	@Column(name="vl_corrida", nullable=false)
	private float valor;
	
	public Corrida() {}

	public Corrida(String origem, String destino, Calendar data, float valor) 
	{
		this.origem = origem;
		this.destino = destino;
		this.data = data;
		this.valor = valor;
	}

	public int getCodigo() 
	{
		return codigo;
	}

	public void setCodigo(int codigo) 
	{
		this.codigo = codigo;
	}

	public String getOrigem() 
	{
		return origem;
	}

	public void setOrigem(String origem) 
	{
		this.origem = origem;
	}

	public String getDestino() 
	{
		return destino;
	}

	public void setDestino(String destino) 
	{
		this.destino = destino;
	}

	public Calendar getData() 
	{
		return data;
	}

	public void setData(Calendar data) 
	{
		this.data = data;
	}

	public float getValor() 
	{
		return valor;
	}

	public void setValor(float valor) 
	{
		this.valor = valor;
	}
	
	
	
	
}
