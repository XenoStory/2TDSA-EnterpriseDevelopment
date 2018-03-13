package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class BuscaTeste 
{
	public static void main(String[] args)
	{
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager manager = factory.createEntityManager();
		
		TimeDAOImpl daotim = new TimeDAOImpl(manager);
		Time time = daotim.buscar(1);
		
		System.out.println(time.getNome());
		System.out.println(time.getTecnico().getNome());
		manager.close();
		factory.close();
	}
}
