package br.com.fiap.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.entity.Cliente;

public class ClienteDAOImpl extends GenericDAOImpl<Cliente,Integer> implements ClienteDAO
{

	public ClienteDAOImpl(EntityManager entityManager) 
	{
		super(entityManager);
	}

	@Override
	public List<Cliente> listar() 
	{
		TypedQuery<Cliente> query = em.createQuery("from Cliente", Cliente.class);
		query.setMaxResults(2);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstado(String estado) 
	{
		TypedQuery<Cliente> query = em.createQuery("from Cliente c where c.endereco.cidade.uf = :estado",Cliente.class);
		query.setParameter("estado", estado);
		return query.getResultList();
	}

	@Override
	public List<Cliente> buscarPorNumeroDias(int dias) 
	{
		return em.createQuery("select cliente from Reserva r where r.numeroDias = :dias", Cliente.class).
				setParameter("dias", dias).getResultList();
	}

	@Override
	public List<Cliente> buscarPorNome(String nome) 
	{
		return em.createQuery("from Cliente where nome like :nome", Cliente.class).setParameter("nome", "%"+nome+"%")
				.getResultList();
	}

	@Override
	public List<Cliente> buscar(String nome, String cidade) 
	{
		return em.createQuery("from Cliente c where c.nome like :nome and c.endereco.cidade.uf like :cidade", Cliente.class)
				.setParameter("nome", "%"+nome+"%" )
				.setParameter("cidade", "%"+cidade+"%")
				.getResultList();
	}

	@Override
	public List<Cliente> buscarPorEstados(List<String> estados) 
	{
		return em.createQuery("from Cliente c where c.endereco.cidade.uf in :estados", Cliente.class)
				.setParameter("estados", estados)
				.getResultList();
	}
	
	
}







