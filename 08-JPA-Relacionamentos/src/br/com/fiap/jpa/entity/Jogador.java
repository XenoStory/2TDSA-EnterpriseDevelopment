package br.com.fiap.jpa.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_JOGADOR")
@SequenceGenerator(name="jogador", sequenceName="SQ_T_JOGADOR", allocationSize=1)
public class Jogador 
{
	@Id
	@GeneratedValue(generator="jogador", strategy=GenerationType.SEQUENCE)
	@Column(name="cd_jogador")
	private int codigo;
	
	@Column(name="nm_jogador", nullable=false, length=50)
	private String nome;
	
	@Column(name="vl_salario")
	private float salario;

	@Column(name="ds_posicao")
	@Enumerated(EnumType.STRING)
	private Posicao posicao;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="cd_time")
	private Time time;
	
	
	public Jogador(String nome, float salario, Posicao posicao) 
	{
		this.nome = nome;
		this.salario = salario;
		this.posicao = posicao;
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

	public float getSalario() 
	{
		return salario;
	}

	public void setSalario(float salario) 
	{
		this.salario = salario;
	}

	public Posicao getPosicao() 
	{
		return posicao;
	}

	public void setPosicao(Posicao posicao) 
	{
		this.posicao = posicao;
	}

	public Time getTime() 
	{
		return time;
	}

	public void setTime(Time time) 
	{
		this.time = time;
	}
}
