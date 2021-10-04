package entidades;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the arista database table.
 * 
 */
@Entity
@NamedQuery(name="Arista.findAll", query="SELECT a FROM Arista a")
public class Arista implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idarista;

	private int peso;

	private int velocidad;

	private int visitable;

	//bi-directional many-to-one association to Nodo
	@ManyToOne
	@JoinColumn(name="idnodoa")
	private Nodo nodo1;

	//bi-directional many-to-one association to Nodo
	@ManyToOne
	@JoinColumn(name="idnodob")
	private Nodo nodo2;

	public Arista() {
	}

	public int getIdarista() {
		return this.idarista;
	}

	public void setIdarista(int idarista) {
		this.idarista = idarista;
	}

	public int getPeso() {
		return this.peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public int getVelocidad() {
		return this.velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getVisitable() {
		return this.visitable;
	}

	public void setVisitable(int visitable) {
		this.visitable = visitable;
	}

	public Nodo getNodo1() {
		return this.nodo1;
	}

	public void setNodo1(Nodo nodo1) {
		this.nodo1 = nodo1;
	}

	public Nodo getNodo2() {
		return this.nodo2;
	}

	public void setNodo2(Nodo nodo2) {
		this.nodo2 = nodo2;
	}

}