package beans;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;



import entidades.Arista;
import entidades.Hospital;

class AristaBeans {
	private static EntityManagerFactory factory;
	private Arista arista;
	private List<Arista> aristas;
	
public AristaBeans(){
		
	}


public void inicializar() {
   try {
	   
  
	factory = Persistence.createEntityManagerFactory("seam");
	// System.out.println("ok");
	EntityManager em = factory.createEntityManager();
	aristas = em.createNamedQuery("Arista.findAll").getResultList();
   }catch (Exception e) {
	System.out.println(e);
}
}

   

	 public void editarArista(int id, int velocidad) {
			try {

				
				factory = Persistence.createEntityManagerFactory("seam");
				EntityManager em = factory.createEntityManager();
				em.getTransaction().begin();
				arista = em.find(Arista.class,id);	
				arista.setVelocidad(velocidad);				
				em.merge(this.arista);
				em.getTransaction().commit();
				em.close();
				inicializar();

			} catch (Exception e) {
				System.out.println(e);
			}
		}



public Arista getArista() {
		return arista;
	}


	public void setArista(Arista arista) {
		this.arista = arista;
	}


	public List<Arista> getAristas() {
		return aristas;
	}


	public void setAristas(List<Arista> aristas) {
		this.aristas = aristas;
	}


}
