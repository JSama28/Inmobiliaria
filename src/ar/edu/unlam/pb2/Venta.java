package ar.edu.unlam.pb2;

public class Venta implements Operador {

	private Propietario propietario;
	private Propiedad propiedad;

	public Venta(Propietario propietario, Propiedad propiedad) {	
		this.propietario = propietario;
		this.propiedad = propiedad;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public Propiedad getPropiedad() {
		return propiedad;
	}

	public void setPropiedad(Propiedad propiedad) {
		this.propiedad = propiedad;
	}

	@Override
	public void operar() {
		propiedad.setPropietario(propietario);
	}
}
