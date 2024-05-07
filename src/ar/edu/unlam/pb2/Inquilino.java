package ar.edu.unlam.pb2;

public class Inquilino extends Cliente {

	private Propiedad id;
	
	
	public Inquilino(String nombre, String apellido, Integer dni, String email, String telefono, Propiedad id) {
		super(nombre, apellido, dni, email, telefono);

		this.id = id;
	}

	public Propiedad getId() {
		return id;
	}


	public void setId(Propiedad id) {
		this.id = id;
	}
}
