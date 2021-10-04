package beans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Conveniohospital;

public class ConvenioHospitalBeans {
	
	private static EntityManagerFactory factory;
	
	private Conveniohospital conveniohospital;
	private List<Conveniohospital> conveniohospitales;

	public  ConvenioHospitalBeans() {
		
	}
	
	
	public void inicializar() {
		   try {
			   
		  
			factory = Persistence.createEntityManagerFactory("seam");			
			EntityManager em = factory.createEntityManager();
			conveniohospitales= em.createNamedQuery("Conveniohospital.findAll").getResultList();
		   }catch (Exception e) {
			System.out.println(e);
		}
		}


	public Conveniohospital getConveniohospital() {
		return conveniohospital;
	}


	public void setConveniohospital(Conveniohospital conveniohospital) {
		this.conveniohospital = conveniohospital;
	}


	public List<Conveniohospital> getConveniohospitales() {
		return conveniohospitales;
	}


	public void setConveniohospitales(List<Conveniohospital> conveniohospitales) {
		this.conveniohospitales = conveniohospitales;
	}
	
	
	
}
