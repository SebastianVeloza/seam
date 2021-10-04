package beans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Arista;
import entidades.Hospital;

public class HospitalBeans {
	private static EntityManagerFactory factory;
	private Hospital hospital;
	private List<Hospital> hospitales;
	
	public HospitalBeans() {
		
	}
	
	public void inicializar() {
		   try {
			   
		  
			factory = Persistence.createEntityManagerFactory("seam");			
			EntityManager em = factory.createEntityManager();
			hospitales= em.createNamedQuery("Hospital.findAll").getResultList();
		   }catch (Exception e) {
			System.out.println(e);
		}
		}
	
	 public void editarHospital(int id, int numpaciente, int tiempo) {
			try {

				
				factory = Persistence.createEntityManagerFactory("seam");
				EntityManager em = factory.createEntityManager();
				em.getTransaction().begin();
				hospital = em.find(Hospital.class,id);	
				hospital.setNumeropacientes(numpaciente);
				hospital.setTiempoconsulta(tiempo);
				em.merge(this.hospital);
				em.getTransaction().commit();
				em.close();
				inicializar();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	
	

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public List<Hospital> getHospitales() {
		return hospitales;
	}

	public void setHospitales(List<Hospital> hospitales) {
		this.hospitales = hospitales;
	}
	
	
	
	
}
