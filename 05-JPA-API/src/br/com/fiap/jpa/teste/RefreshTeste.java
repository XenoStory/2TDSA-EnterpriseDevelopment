package br.com.fiap.jpa.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fiap.jpa.entity.Publicacao;

public class RefreshTeste {

	public static void main(String[] args) {
		//Criar o Entity Manager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("2tdsa");
		EntityManager em = fabrica.createEntityManager();
		
		//Buscar uma publicacao
		Publicacao p = em.find(Publicacao.class, 1);
		
		//Exibir o conteúdo
		System.out.println(p.getConteudo());
		
		//Alterar o conteúdo da publicacao no java
		p.setConteudo("Teste Refresh");
		
		//Exibir o conteúdo
		System.out.println(p.getConteudo());
		
		//Refresh
		em.refresh(p);
		
		//Exibir o conteúdo
		System.out.println(p.getConteudo());
		
		em.close();
		fabrica.close();
	}
	
}