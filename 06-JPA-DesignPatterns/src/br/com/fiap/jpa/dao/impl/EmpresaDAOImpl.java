package br.com.fiap.jpa.dao.impl;

import br.com.fiap.jpa.entity.Empresa;
import javax.persistence.EntityManager;
import br.com.fiap.jpa.dao.EmpresaDAO;

public class EmpresaDAOImpl 
				extends GenericDAOImpl<Empresa, String>
										implements EmpresaDAO 
{

	public EmpresaDAOImpl(EntityManager em) 
	{
		super(em);
	}

}