import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.lei.jpa.entity.Carro;
import com.lei.jpa.entity.Pais;
import com.lei.jpa.entity.Placa;

import br.com.fiap.dao.impl.CarroDAOImpl;
import br.com.fiap.singleton.EntityManagerFactorySingleton;

public class TesteCadastrar 
{
	public static void main(String[] args)
	{
		EntityManagerFactory factory = EntityManagerFactorySingleton.getInstance();
		EntityManager manager = factory.createEntityManager();
		
		Placa p = new Placa("ABC-1234", Pais.BRASIL);
		Carro c = new Carro(43578920, "Preto", 2007);
		c.setPlaca(p);
		
		CarroDAOImpl dao = new CarroDAOImpl(manager);
		
		try 
		{
			dao.cadastrar(c);
			dao.commit();
		} catch (Exception e) 
		{
			System.err.println(e.getMessage());
		}
		
		manager.close();
		factory.close();
	}
}
