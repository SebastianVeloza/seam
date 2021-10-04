package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the conveniohospital database table.
 * 
 */
@Entity
@NamedQuery(name="Conveniohospital.findAll", query="SELECT c FROM Conveniohospital c")
public class Conveniohospital implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idconveniohospital;

	//bi-directional many-to-one association to Convenio
	@ManyToOne
	@JoinColumn(name="idconvenio")
	private Convenio convenio;

	//bi-directional many-to-one association to Hospital
	@ManyToOne
	@JoinColumn(name="idhospital")
	private Hospital hospital;

	public Conveniohospital() {
	}

	public int getIdconveniohospital() {
		return this.idconveniohospital;
	}

	public void setIdconveniohospital(int idconveniohospital) {
		this.idconveniohospital = idconveniohospital;
	}

	public Convenio getConvenio() {
		return this.convenio;
	}

	public void setConvenio(Convenio convenio) {
		this.convenio = convenio;
	}

	public Hospital getHospital() {
		return this.hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

}