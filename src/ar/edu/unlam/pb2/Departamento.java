package ar.edu.unlam.pb2;

public class Departamento extends Propiedad {

	private String numDep;
	private Inquilino inquilino;
	
	public Departamento(String calle, Integer numero, String numDep, String ciudad, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipo, Propietario propietario, Inquilino inquilino, String id) {
		super(calle, numero, ciudad, precio, estaDisponible, tipo, propietario, id);
		
		this.numDep = numDep;
		this.inquilino = inquilino;
	}

	public String getNumDep() {
		return numDep;
	}

	public void setNumDep(String numDep) {
		this.numDep = numDep;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}
	
	@Override
	public String toString() {
		return "Id: " + super.getId() + ", Calle: " + super.getCalle() + " " + super.getNumero() + ", Departamento: " + numDep + ", Ciudad: " + super.getCiudad() + ", Precio: " 
				+ super.getPrecio() + ", esta " 	+ (super.getEstaDisponible() == true ? "Disponible, " : "No disponible, ") + super.getTipo() + ", Propietario: " + 
				super.getPropietario().getNombre() + " "  + super.getPropietario().getApellido() + " Inquilino: " + inquilino.getNombre() + " " + inquilino.getApellido();
	}
}
