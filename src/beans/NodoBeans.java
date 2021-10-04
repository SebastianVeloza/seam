package beans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Nodo;

public class NodoBeans {

	
	private static EntityManagerFactory factory;
	
	private Nodo nodo;
	private List<Nodo> nodos;
	
	
	public NodoBeans() {
		
	}
	
	public void inicializar() {
		   try {
			   
		  
			factory = Persistence.createEntityManagerFactory("seam");
			// System.out.println("ok");
			EntityManager em = factory.createEntityManager();
			nodos= em.createNamedQuery("Nodo.findAll").getResultList();
		   }catch (Exception e) {
			System.out.println(e);
		}
		}

	public Nodo getNodo() {
		return nodo;
	}

	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}

	public List<Nodo> getNodos() {
		return nodos;
	}

	public void setNodos(List<Nodo> nodos) {
		this.nodos = nodos;
	}
	
	
}
