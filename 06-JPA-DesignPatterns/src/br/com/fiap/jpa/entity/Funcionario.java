package br.com.fiap.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_FUNCIONARIO")
@SequenceGenerator(name="func",sequenceName="SQ_T_FUNCIONARIO",allocationSize=1)
public class Funcionario implements Serializable {

	@Id
	@Column(name="cd_funcionario")
	@GeneratedValue(generator="func",strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_funcionario",nullable=false,length=100)
	private String nome;
	
	@Column(name="ds_cargo",length=20)
	private String cargo;
	
	public Funcionario() {
		super();
	}

	public Funcionario(String nome, String cargo) {
		super();
		this.nome = nome;
		this.cargo = cargo;
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

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

}
