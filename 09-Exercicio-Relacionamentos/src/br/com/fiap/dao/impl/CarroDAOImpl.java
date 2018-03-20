package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import com.lei.jpa.entity.Carro;

import br.com.fiap.dao.CarroDAO;

public class CarroDAOImpl extends GenericDAOImpl<Carro, Integer> implements CarroDAO
{

	public CarroDAOImpl(EntityManager manager) 
	{
		super(manager);
	}
}
