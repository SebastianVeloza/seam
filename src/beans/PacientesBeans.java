package beans;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entidades.Paciente;

public class PacientesBeans {

	private static EntityManagerFactory factory;

	private Paciente paciente;
	private List<Paciente> pacientes;

	public PacientesBeans() {

	}

	public void inicializar() {
		try {

			factory = Persistence.createEntityManagerFactory("seam");
			EntityManager em = factory.createEntityManager();
			pacientes = em.createNamedQuery("Paciente.findAll").getResultList();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void guardarPaciente() {
		try {

			factory = Persistence.createEntityManagerFactory("seam");
			EntityManager em = factory.createEntityManager();
			em.getTransaction().begin();
			em.persist(this.paciente);
			em.getTransaction().commit();
			em.close();
			inicializar();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public List<Paciente> getPacientes() {
		return pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

}
