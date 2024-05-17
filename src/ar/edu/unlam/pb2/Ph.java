package ar.edu.unlam.pb2;

public class Ph extends Propiedad {

	private String numPh;
	private Inquilino inquilino;	
		
	public Ph(String calle, Integer numero, String numPh, String ciudad, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipo, Propietario propietario, String id) {
		super(calle, numero, ciudad, precio, estaDisponible, tipo, propietario, id);
		
		this.numPh = numPh;
	}

	public String getNumPh() {
		return numPh;
	}


	public void setNumPh(String numPh) {
		this.numPh = numPh;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}
	
	@Override	
	public String toString() {
		return "Id: " + super.getId() + ", Calle: " + super.getCalle() + " " + super.getNumero() + ", Ph: " + numPh + ", Ciudad: " + super.getCiudad() + ", Precio: " 
				+ super.getPrecio() + ", esta " 	+ (super.getEstaDisponible() == true ? "Disponible, " : "No disponible, ") + super.getTipo() + ", Propietario: " + 
				super.getPropietario().getNombre() + " "  + super.getPropietario().getApellido() /*+ " Inquilino: " + inquilino.getNombre() + " " + inquilino.getApellido()*/;
	}	
}
