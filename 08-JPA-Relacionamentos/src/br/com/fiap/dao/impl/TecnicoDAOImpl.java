package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.TecnicoDAO;
import br.com.fiap.jpa.entity.Tecnico;

public class TecnicoDAOImpl extends GenericDAOImpl<Tecnico, Integer> implements TecnicoDAO
{
	public TecnicoDAOImpl(EntityManager manager)
	{
		super(manager);
	}
}
