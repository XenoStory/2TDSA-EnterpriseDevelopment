package br.com.fiap.view;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.CidadeDAO;
import br.com.fiap.dao.ClienteDAO;
import br.com.fiap.dao.EntityManagerFactorySingleton;
import br.com.fiap.dao.PacoteDAO;
import br.com.fiap.dao.TransporteDAO;
import br.com.fiap.dao.impl.CidadeDAOImpl;
import br.com.fiap.dao.impl.ClienteDAOImpl;
import br.com.fiap.dao.impl.PacoteDAOImpl;
import br.com.fiap.dao.impl.TransporteDAOImpl;
import br.com.fiap.entity.Cidade;
import br.com.fiap.entity.Cliente;
import br.com.fiap.entity.Pacote;
import br.com.fiap.entity.Transporte;

public class ConsoleView 
{

	public static void main(String[] args) 
	{
		EntityManagerFactory fabrica = EntityManagerFactorySingleton.getInstance();
		EntityManager em =  fabrica.createEntityManager();
		
		// Listar as cidades
		CidadeDAO dao = new CidadeDAOImpl(em);
		
		System.out.println("LISTAR TODAS AS CIDADES");
		List<Cidade> cidades = dao.listar();
		// Exibir as cidades
		for(Cidade c : cidades)
		{
			System.out.println(c.getNome() + " - " + c.getUf());
		}
		
		// Buscar por estado
		System.out.println("BUSCAR POR ESTADO");
		cidades = dao.buscarPorEstado("BA");
		// Exibir as cidades
		for (Cidade cidade : cidades) 
		{
			System.out.println(cidade.getNome());
		}
		
		ClienteDAO daoCliente = new ClienteDAOImpl(em);
		
		// Listar clientes
		System.out.println("LISTAR TODOS OS CLIENTES");
		List<Cliente> clientes = daoCliente.listar();
		
		for (Cliente cliente : clientes) 
		{
			System.out.println(cliente.getNome());
		}
		
		System.out.println("LISTAR PACOTES POR TIPO DE TRANSPORTE");
		PacoteDAO daoPacote = new PacoteDAOImpl(em);
		TransporteDAO daoTransporte = new TransporteDAOImpl(em);
		// Lista pacotes por tipo de transporte
		Transporte t = daoTransporte.pesquisar(1);
		List<Pacote> pacotes = daoPacote.listarPorTransporte(t);
		
		for (Pacote pacote : pacotes) 
		{
			System.out.println(pacote.getDescricao());
		}
		
		// Listar clientes por estado
		System.out.println("LISTAR CLIENTES POR ESTADO");
		List<Cliente> lClientes = daoCliente.buscarPorEstado("SP");
		for (Cliente cliente : lClientes) 
		{
			System.out.println(cliente.getNome());
		}
		
		System.out.println("LISTAR CLIENTES POR NÚMERO DE DIAS DE RESERVA");
		lClientes = daoCliente.buscarPorNumeroDias(10);
		for (Cliente cliente : lClientes) 
		{
			System.out.println(cliente.getNome());
		}
		
		System.out.println("LISTAR CLIENTES PELO NOME");
		lClientes = daoCliente.buscarPorNome("a");
		for(Cliente cliente : lClientes)
		{
			System.out.println(cliente.getNome());
		}
		
		System.out.println("LISTAR PACOTES POR DATAS");
		pacotes = daoPacote.buscarPorDatas(new GregorianCalendar(2017, Calendar.JULY, 13), 
				new GregorianCalendar(2017, Calendar.SEPTEMBER, 2));
		for (Pacote pacote : pacotes) 
		{
			System.out.println(pacote.getDescricao());
		}
		System.out.println("LISTAR POR NOME DA PESSOA E PELA CIDADE");
		lClientes = daoCliente.buscar("a", "SP");
		for (Cliente cliente : lClientes) 
		{
			System.out.println(cliente.getNome());
		}
		
		System.out.println("LISTAR CLIENTES POR ESTADO");
		lClientes = daoCliente.buscarPorEstado("PR");
		for(Cliente cliente : lClientes)
		{
			System.out.println(cliente.getNome());
		}
		
		em.close();
		fabrica.close();
	}

}



