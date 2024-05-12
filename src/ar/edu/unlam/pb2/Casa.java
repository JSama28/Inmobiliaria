package ar.edu.unlam.pb2;

import java.util.Objects;

public class Casa extends Propiedad{

	private Inquilino inquilino;
	
	
	public Casa(String calle, Integer numero, String ciudad, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipo, Propietario propietario, String id) {
		super(calle, numero, ciudad, precio, estaDisponible, tipo, propietario, id);
		
		this.inquilino = inquilino;
	}
	
	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getCalle(), getNumero(), getCiudad(), getPrecio());
	}
	
	@Override
	public boolean equals(Object obj) {
		Casa casa = (Casa) obj;
		return casa.getCalle().equals(getCalle()) && 
				casa.getNumero().equals(getNumero()) && 
				casa.getCiudad().equals(getCiudad()) && 
				casa.getPrecio().equals(getPrecio());
	}
/*	
	@Override
    public String toString() {
        return super.toString() + " Inquilino: " + inquilino.getNombre() + " " + inquilino.getApellido();
    }*/
}
