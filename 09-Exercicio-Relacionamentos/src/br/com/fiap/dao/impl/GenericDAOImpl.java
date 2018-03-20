package br.com.fiap.dao.impl;

import java.lang.reflect.ParameterizedType;

import javax.persistence.EntityManager;

import br.com.fiap.dao.GenericDAO;
import br.com.fiap.exception.CommitException;
import br.com.fiap.exception.RegistroNaoEncontradoException;

public class GenericDAOImpl<Tabela, Chave >implements GenericDAO<Tabela, Chave>
{
	private EntityManager manager;
	private Class<Tabela> clazz;
	
	@SuppressWarnings("unchecked")
	public GenericDAOImpl(EntityManager manager) 
	{
		this.manager = manager;
		clazz = (Class<Tabela>)
			((ParameterizedType)
				getClass().getGenericSuperclass())
					.getActualTypeArguments()[0];
	}
	
	@Override
	public void cadastrar(Tabela tabela) 
	{
		manager.persist(tabela);
	}

	@Override
	public void atualizar(Tabela tabela) 
	{
		manager.merge(tabela);
	}

	@Override
	public void excluir(Chave codigo) throws RegistroNaoEncontradoException
	{
		Tabela t = buscar(codigo);
		if(t == null)
		{
			throw new RegistroNaoEncontradoException("Registro não encontrado...");
		}
		manager.remove(t);
	}

	@Override
	public Tabela buscar(Chave codigo) 
	{
		return manager.find(clazz, codigo);
	}

	@Override
	public void commit() throws CommitException 
	{
		try
		{
			manager.getTransaction().begin();
			manager.getTransaction().commit();
		}
		catch(Exception e)
		{
			if(manager.getTransaction().isActive())
			{
				manager.getTransaction().rollback();
			}
			e.printStackTrace();
			throw new CommitException("Erro ao gravar");
		}
	}

}
