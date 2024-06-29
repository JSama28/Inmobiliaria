package ar.edu.unlam.pb2;

public class Casa extends Propiedad{

	private String numCasa;
	
	public Casa(String calle, Integer numero, String numCasa, String ciudad, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipo, Propietario propietario, String id) {
		super(calle, numero, ciudad, precio, estaDisponible, tipo, propietario, id);
	}

	public String getNumCasa() {
		return numCasa;
	}

	public void setNumCasa(String numCasa) {
		this.numCasa = numCasa;
	}
	
}
