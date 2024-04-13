package ar.edu.unlam.pb2;

public class Venta {
	
	private Propietario duenioVende;
	private Cliente duenioNuevo;
	private Propietario duenioCompro;
	private Propiedad propiedad;
	
	
	public Venta(Propietario duenioVende, Cliente duenioNuevo, Propietario duenioCompro, Propiedad propiedad) {
		super();
		this.duenioVende = duenioVende;
		this.duenioNuevo = duenioNuevo;
		this.duenioCompro = duenioCompro;
		this.propiedad = propiedad;
	}


	public Propietario getDuenioVende() {
		return duenioVende;
	}


	public void setDuenioVende(Propietario duenioVende) {
		this.duenioVende = duenioVende;
	}


	public Cliente getDuenioNuevo() {
		return duenioNuevo;
	}


	public void setDuenioNuevo(Cliente duenioNuevo) {
		this.duenioNuevo = duenioNuevo;
	}


	public Propietario getDuenioCompro() {
		return duenioCompro;
	}


	public void setDuenioCompro(Propietario duenioCompro) {
		this.duenioCompro = duenioCompro;
	}


	public Propiedad getPropiedad() {
		return propiedad;
	}


	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
	
	
	
	

}
