package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import com.lei.jpa.entity.Motorista;

import br.com.fiap.dao.MotoristaDAO;

public class MotoristaDAOImpl extends GenericDAOImpl<Motorista, Integer> implements MotoristaDAO
{

	public MotoristaDAOImpl(EntityManager manager) 
	{
		super(manager);
	}
}
