package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the hospital database table.
 * 
 */
@Entity
@NamedQuery(name="Hospital.findAll", query="SELECT h FROM Hospital h")
public class Hospital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idhospital;

	private int numeropacientes;

	private int tiempoconsulta;

	//bi-directional many-to-one association to Conveniohospital
	@OneToMany(mappedBy="hospital")
	private List<Conveniohospital> conveniohospitals;

	//bi-directional many-to-one association to Nodo
	@ManyToOne
	@JoinColumn(name="idnodo")
	private Nodo nodo;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="hospital")
	private List<Paciente> pacientes;

	public Hospital() {
	}

	public int getIdhospital() {
		return this.idhospital;
	}

	public void setIdhospital(int idhospital) {
		this.idhospital = idhospital;
	}

	public int getNumeropacientes() {
		return this.numeropacientes;
	}

	public void setNumeropacientes(int numeropacientes) {
		this.numeropacientes = numeropacientes;
	}

	public int getTiempoconsulta() {
		return this.tiempoconsulta;
	}

	public void setTiempoconsulta(int tiempoconsulta) {
		this.tiempoconsulta = tiempoconsulta;
	}

	public List<Conveniohospital> getConveniohospitals() {
		return this.conveniohospitals;
	}

	public void setConveniohospitals(List<Conveniohospital> conveniohospitals) {
		this.conveniohospitals = conveniohospitals;
	}

	public Conveniohospital addConveniohospital(Conveniohospital conveniohospital) {
		getConveniohospitals().add(conveniohospital);
		conveniohospital.setHospital(this);

		return conveniohospital;
	}

	public Conveniohospital removeConveniohospital(Conveniohospital conveniohospital) {
		getConveniohospitals().remove(conveniohospital);
		conveniohospital.setHospital(null);

		return conveniohospital;
	}

	public Nodo getNodo() {
		return this.nodo;
	}

	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente addPaciente(Paciente paciente) {
		getPacientes().add(paciente);
		paciente.setHospital(this);

		return paciente;
	}

	public Paciente removePaciente(Paciente paciente) {
		getPacientes().remove(paciente);
		paciente.setHospital(null);

		return paciente;
	}

}