package beans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Convenio;

public class ConveniosBeans {

	private static EntityManagerFactory factory;
	
	private Convenio convenio;
	private List<Convenio> convenios;
	
	public   ConveniosBeans() {
		// TODO Auto-generated constructor stub		
	}
	
	public void inicializar() {
		   try {
			   
		  
			factory = Persistence.createEntityManagerFactory("seam");			
			EntityManager em = factory.createEntityManager();
			convenios= em.createNamedQuery("Convenio.findAll").getResultList();
		   }catch (Exception e) {
			System.out.println(e);
		}
		}

	public Convenio getConvenio() {
		return convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public List<Convenio> getConvenios() {
		return convenios;
	}

	public void setConvenios(List<Convenio> convenios) {
		this.convenios = convenios;
	}
	
	
	
	
}
