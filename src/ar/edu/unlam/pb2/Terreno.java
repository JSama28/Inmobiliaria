package ar.edu.unlam.pb2;

public class Terreno extends Propiedad{
	
	private Double mtsCuadrados;	
	
	public Terreno(String calle, Integer numero, String ciudad, Double mtsCuadrados, Double precio,
			Boolean estaDisponible, TipoDeOperacion tipo, Propietario propietario, String id) {
		super(calle, numero, ciudad, precio, estaDisponible, tipo, propietario, id);

		this.mtsCuadrados = mtsCuadrados;

	}

	public Double getMtsCuadrados() {
		return mtsCuadrados;
	}

	public void setMtsCuadrados(Double mtsCuadrados) {
		this.mtsCuadrados = mtsCuadrados;
	}

	@Override
	public String toString() {
		return "Id: " + super.getId() + ", Calle: " + super.getCalle() + " " + super.getNumero() + ", Ciudad: " + super.getCiudad() + ", Mts cuadrados: " + mtsCuadrados + 
				", Precio: " + super.getPrecio() + ", esta " 	+ (super.getEstaDisponible() == true ? "Disponible, " : "No disponible, ") + super.getTipo() + ", Propietario: " + 
					super.getPropietario().getNombre() + " "  + super.getPropietario().getApellido();
		}	
}
