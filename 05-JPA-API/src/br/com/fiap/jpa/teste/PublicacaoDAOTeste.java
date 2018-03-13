package br.com.fiap.jpa.teste;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.dao.PublicacaoDAO;
import br.com.fiap.jpa.dao.impl.PublicacaoDAOImpl;
import br.com.fiap.jpa.entity.PrivacidadePublicacao;
import br.com.fiap.jpa.entity.Publicacao;
import br.com.fiap.jpa.exception.CommitException;
import br.com.fiap.jpa.exception.RegistroNaoEncontradoException;

public class PublicacaoDAOTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("2tdsa");
		EntityManager em = fabrica.createEntityManager();
		
		PublicacaoDAO dao = new PublicacaoDAOImpl(em);
		
		Publicacao p = new Publicacao("Cabral",
				Calendar.getInstance(), null, 
				"GIT", 10, PrivacidadePublicacao.PRIVADO);
		
		try {
			dao.cadastrar(p);
			dao.commit();
			System.out.println("Sucesso!");
		} catch (CommitException e) {
			System.out.println("Erro");
		}
		
		//Buscar
		Publicacao p2 = dao.buscar(2);
		System.out.println(p2.getAutor());
		
		//Atualizar
		p2.setConteudo("Android");
		try {
			dao.modificar(p2);
			dao.commit();
			System.out.println("Modificado!");
		} catch (CommitException e) {
			System.out.println("Erro");
		}

		//Remoção
		try {
			dao.apagar(2);
			dao.commit();
			System.out.println("Apagado com sucesso!");
		} catch (RegistroNaoEncontradoException e) {
			System.out.println(e.getMessage());
		} catch (CommitException e) {
			System.out.println(e.getMessage());
		}
		
		em.close();
		fabrica.close();
	}
	
}
