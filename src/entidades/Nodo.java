package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the nodo database table.
 * 
 */
@Entity
@NamedQuery(name="Nodo.findAll", query="SELECT n FROM Nodo n")
public class Nodo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idnodo;

	private String latitudnodo;

	private String longitudnodo;

	private String nombre;

	//bi-directional many-to-one association to Arista
	@OneToMany(mappedBy="nodo1")
	private List<Arista> aristas1;

	//bi-directional many-to-one association to Arista
	@OneToMany(mappedBy="nodo2")
	private List<Arista> aristas2;

	//bi-directional many-to-one association to Hospital
	@OneToMany(mappedBy="nodo")
	private List<Hospital> hospitals;

	//bi-directional many-to-one association to Paciente
	@OneToMany(mappedBy="nodo")
	private List<Paciente> pacientes;

	public Nodo() {
	}

	public int getIdnodo() {
		return this.idnodo;
	}

	public void setIdnodo(int idnodo) {
		this.idnodo = idnodo;
	}

	public String getLatitudnodo() {
		return this.latitudnodo;
	}

	public void setLatitudnodo(String latitudnodo) {
		this.latitudnodo = latitudnodo;
	}

	public String getLongitudnodo() {
		return this.longitudnodo;
	}

	public void setLongitudnodo(String longitudnodo) {
		this.longitudnodo = longitudnodo;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Arista> getAristas1() {
		return this.aristas1;
	}

	public void setAristas1(List<Arista> aristas1) {
		this.aristas1 = aristas1;
	}

	public Arista addAristas1(Arista aristas1) {
		getAristas1().add(aristas1);
		aristas1.setNodo1(this);

		return aristas1;
	}

	public Arista removeAristas1(Arista aristas1) {
		getAristas1().remove(aristas1);
		aristas1.setNodo1(null);

		return aristas1;
	}

	public List<Arista> getAristas2() {
		return this.aristas2;
	}

	public void setAristas2(List<Arista> aristas2) {
		this.aristas2 = aristas2;
	}

	public Arista addAristas2(Arista aristas2) {
		getAristas2().add(aristas2);
		aristas2.setNodo2(this);

		return aristas2;
	}

	public Arista removeAristas2(Arista aristas2) {
		getAristas2().remove(aristas2);
		aristas2.setNodo2(null);

		return aristas2;
	}

	public List<Hospital> getHospitals() {
		return this.hospitals;
	}

	public void setHospitals(List<Hospital> hospitals) {
		this.hospitals = hospitals;
	}

	public Hospital addHospital(Hospital hospital) {
		getHospitals().add(hospital);
		hospital.setNodo(this);

		return hospital;
	}

	public Hospital removeHospital(Hospital hospital) {
		getHospitals().remove(hospital);
		hospital.setNodo(null);

		return hospital;
	}

	public List<Paciente> getPacientes() {
		return this.pacientes;
	}

	public void setPacientes(List<Paciente> pacientes) {
		this.pacientes = pacientes;
	}

	public Paciente addPaciente(Paciente paciente) {
		getPacientes().add(paciente);
		paciente.setNodo(this);

		return paciente;
	}

	public Paciente removePaciente(Paciente paciente) {
		getPacientes().remove(paciente);
		paciente.setNodo(null);

		return paciente;
	}

}