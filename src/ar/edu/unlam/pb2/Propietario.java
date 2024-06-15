package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Propietario extends Cliente{
	private ArrayList<Propiedad> propiedades;
	
	public Propietario(String nombre, String apellido, Integer dni, String email, String telefono) {
		super(nombre, apellido, dni, email, telefono);
	
		this.propiedades = new ArrayList<Propiedad>();	
	}

	public ArrayList<Propiedad> getPropiedades() {
		return propiedades;
	}

	public Boolean agregarPropiedad(Propiedad propiedad) {
		return this.propiedades.add(propiedad);
		
	}
	
	public Boolean borrarPropiedad(Propiedad propiedades) {
		return this.propiedades.remove(propiedades);		
	}

}
