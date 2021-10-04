package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the paciente database table.
 * 
 */
@Entity
@NamedQuery(name="Paciente.findAll", query="SELECT p FROM Paciente p")
public class Paciente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idpaciente;

	private String nombrePaciente;

	//bi-directional many-to-one association to Hospital
	@ManyToOne
	@JoinColumn(name="idnodohospital")
	private Hospital hospital;

	//bi-directional many-to-one association to Nodo
	@ManyToOne
	@JoinColumn(name="idnodoorigen")
	private Nodo nodo;

	public Paciente() {
	}

	public int getIdpaciente() {
		return this.idpaciente;
	}

	public void setIdpaciente(int idpaciente) {
		this.idpaciente = idpaciente;
	}

	public String getNombrePaciente() {
		return this.nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Nodo getNodo() {
		return this.nodo;
	}

	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}

}