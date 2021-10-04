package entidades;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the convenio database table.
 * 
 */
@Entity
@NamedQuery(name="Convenio.findAll", query="SELECT c FROM Convenio c")
public class Convenio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idconvenio;

	private String nombreconvenio;

	//bi-directional many-to-one association to Conveniohospital
	@OneToMany(mappedBy="convenio")
	private List<Conveniohospital> conveniohospitals;

	public Convenio() {
	}

	public int getIdconvenio() {
		return this.idconvenio;
	}

	public void setIdconvenio(int idconvenio) {
		this.idconvenio = idconvenio;
	}

	public String getNombreconvenio() {
		return this.nombreconvenio;
	}

	public void setNombreconvenio(String nombreconvenio) {
		this.nombreconvenio = nombreconvenio;
	}

	public List<Conveniohospital> getConveniohospitals() {
		return this.conveniohospitals;
	}

	public void setConveniohospitals(List<Conveniohospital> conveniohospitals) {
		this.conveniohospitals = conveniohospitals;
	}

	public Conveniohospital addConveniohospital(Conveniohospital conveniohospital) {
		getConveniohospitals().add(conveniohospital);
		conveniohospital.setConvenio(this);

		return conveniohospital;
	}

	public Conveniohospital removeConveniohospital(Conveniohospital conveniohospital) {
		getConveniohospitals().remove(conveniohospital);
		conveniohospital.setConvenio(null);

		return conveniohospital;
	}

}