package br.com.fiap.dao.impl;

import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class PacoteDAOImpl extends GenericDAOImpl<Pacote,Integer> implements PacoteDAO{

	public PacoteDAOImpl(EntityManager entityManager) 
	{
		super(entityManager);
	}

	@Override
	public List<Pacote> listarPorTransporte(Transporte transporte) 
	{
		TypedQuery<Pacote> query = em.createQuery("from Pacote where transporte = :transporte", Pacote.class);
		
		query.setParameter("transporte",transporte);
		
		return query.getResultList();
	}

	@Override
	public List<Pacote> buscarPorDatas(Calendar inicio, Calendar fim) 
	{
		return em.createQuery("from Pacote where dataSaida between :inicio and :fim ", Pacote.class)
				.setParameter("inicio", inicio)
				.setParameter("fim", fim)
				.getResultList();
	}
	
	
	

}
