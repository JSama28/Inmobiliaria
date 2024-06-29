package ar.edu.unlam.pb2;

public class Inquilino extends Cliente {

	private Propiedad propiedad;
	
	
	public Inquilino(String nombre, String apellido, Integer dni, String email, String telefono, Propiedad propiedad) {
		super(nombre, apellido, dni, email, telefono);

		this.propiedad = propiedad;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}


	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}
}
