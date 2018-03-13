package br.com.fiap.jpa.main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.TecnicoDAOImpl;
import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.jpa.entity.Tecnico;
import br.com.fiap.jpa.entity.Time;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class CadastroTeste 
{
	public static void main(String[] args)
	{
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager manager = factory.createEntityManager();

		TimeDAOImpl daot = new TimeDAOImpl(manager);

		TecnicoDAOImpl daotec = new TecnicoDAOImpl(manager);

		//Tecnico tec= new Tecnico("Gustavo", true);
		Tecnico tec = new Tecnico();
		Time tim = new Time("Barcelona", 2, tec);
		
		try
		{
			daotec.cadastrar(tec);
			daot.cadastrar(tim);
			daotec.commit();
			System.out.println("Cadastro realizado com sucesso.");
		}
		catch(Exception e)
		{
			System.err.println(e.getMessage());
		}

		manager.close();
		factory.close();
	}
}
