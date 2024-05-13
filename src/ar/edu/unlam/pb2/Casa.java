package ar.edu.unlam.pb2;

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
	
}
