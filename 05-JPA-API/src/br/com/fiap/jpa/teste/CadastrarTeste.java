package br.com.fiap.jpa.teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.PrivacidadePublicacao;
import br.com.fiap.jpa.entity.Publicacao;

public class CadastrarTeste {

	public static void main(String[] args) {
		EntityManagerFactory fabrica = 
			Persistence.createEntityManagerFactory("2tdsa");
		EntityManager em = fabrica.createEntityManager();
		
		Publicacao p = new Publicacao("Thiago", 
			Calendar.getInstance(), 
			null, "Ola Mundo", 0, PrivacidadePublicacao.PUBLICO);
		
		em.persist(p);
		em.getTransaction().begin();
		em.getTransaction().commit();
		
		em.close();
		fabrica.close();
	}
	
}