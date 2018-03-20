package com.lei.jpa.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="T_MOTORISTA")
@SequenceGenerator(name="motorista", sequenceName="T_SQ_MOTORISTA", allocationSize=1)
public class Motorista 
{
	@Id
	@Column(name="cd_motorista")
	@GeneratedValue(generator="motorista", strategy=GenerationType.SEQUENCE)
	private int codigo;
	
	@Column(name="nm_motorista", nullable=false)
	private String nome;
}
