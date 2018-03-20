package br.com.fiap.jpa.main;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import br.com.fiap.dao.impl.TimeDAOImpl;
import br.com.fiap.jpa.entity.Jogador;
import br.com.fiap.jpa.entity.Patrocinio;
import br.com.fiap.jpa.entity.Posicao;
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

		Tecnico tec= new Tecnico("Gustavo", true);
		Time tim = new Time("Barcelona", 2, tec);
		Jogador j1 = new Jogador("Messi", 35000000, Posicao.VOLANTE);
		Jogador j2 = new Jogador("Suarez", 35000000, Posicao.ATACANTE);
		Jogador j3 = new Jogador("Pique", 35000000, Posicao.ZAGUEIRO);
		
		Patrocinio p1 = new Patrocinio("Adidas", 100000000);
		Patrocinio p2 = new Patrocinio("Balalaika", 20000000);
		Patrocinio p3 = new Patrocinio("Jurassic Park", 200000000);
		
		tim.adicionarJogador(j1);
		tim.adicionarJogador(j2);
		tim.adicionarJogador(j3);
		
		List<Patrocinio> patrocinios = new ArrayList<>();
		patrocinios.add(p1);
		patrocinios.add(p2);
		patrocinios.add(p3);
		
		tim.setPatrocinios(patrocinios);
		
		try
		{
			daot.cadastrar(tim);
			daot.commit();
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
