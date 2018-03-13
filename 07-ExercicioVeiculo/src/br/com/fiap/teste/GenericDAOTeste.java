package br.com.fiap.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.PagamentoDAOImpl;
import br.com.fiap.entity.FormaPagamento;
import br.com.fiap.entity.Pagamento;
import br.com.fiap.exception.CommitException;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class GenericDAOTeste 
{
	public static void main(String[] args)
	{
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		
		EntityManager manager = factory.createEntityManager();
		
		Pagamento p = new Pagamento(Calendar.getInstance(), 150, FormaPagamento.DINHEIRO);
		PagamentoDAOImpl dao = new PagamentoDAOImpl(manager);
		
		try
		{
			dao.cadastrar(p);
			dao.commit();
			System.out.println("Cadastro realizado com sucesso!");
		}
		catch(CommitException e)
		{
			System.err.println(e.getMessage());
		}
		
		manager.close();
		factory.close();
	}
}
