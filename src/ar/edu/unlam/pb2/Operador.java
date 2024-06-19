package ar.edu.unlam.pb2;

public interface Operador {
	
	public Boolean realizarVenta(String propiedadAVender, Propietario propietarioCompraNuevo);
	
	public Boolean realizarAlquiler(String propiedadAAlquilar, Inquilino inquilino, String fechaInicio, String fechaFin);
	
	public Boolean realizarPermuta(Propietario propietarioA, Propiedad propA, Propietario propietarioB, Propiedad propB);
}
