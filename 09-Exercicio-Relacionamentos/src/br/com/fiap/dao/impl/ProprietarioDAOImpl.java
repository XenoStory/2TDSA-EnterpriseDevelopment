package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import com.lei.jpa.entity.Proprietario;

import br.com.fiap.dao.ProprietarioDAO;

public class ProprietarioDAOImpl extends GenericDAOImpl<Proprietario, Integer> implements ProprietarioDAO
{

	public ProprietarioDAOImpl(EntityManager manager) 
	{
		super(manager);
	}
	
}
