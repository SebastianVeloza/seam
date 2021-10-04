package beans;

public class Rutas {
	
	private String ruta;
	private int peso;
	private int paciente;
	private int timpopaciente;
	private int tiempollegada;
	public int getTimpopaciente() {
		return timpopaciente;
	}


	public void setTimpopaciente(int timpopaciente) {
		this.timpopaciente = timpopaciente;
	}


	public int getTiempollegada() {
		return tiempollegada;
	}


	public void setTiempollegada(int tiempollegada) {
		this.tiempollegada = tiempollegada;
	}


	private int tiempototal;
	
	
	public Rutas() {		
	}


	public String getRuta() {
		return ruta;
	}


	public void setRuta(String ruta) {
		this.ruta = ruta;
	}


	public int getPeso() {
		return peso;
	}


	public void setPeso(int peso) {
		this.peso = peso;
	}


	public int getPaciente() {
		return paciente;
	}


	public void setPaciente(int paciente) {
		this.paciente = paciente;
	}


	public int getTiempototal() {
		return tiempototal;
	}


	public void setTiempototal(int tiempototal) {
		this.tiempototal = tiempototal;
	}


	

}
