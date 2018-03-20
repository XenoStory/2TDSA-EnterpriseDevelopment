package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import com.lei.jpa.entity.Placa;

import br.com.fiap.dao.PlacaDAO;

public class PlacaDAOImpl extends GenericDAOImpl<Placa, Integer> implements PlacaDAO
{

	public PlacaDAOImpl(EntityManager manager)
	{
		super(manager);
	}
}
