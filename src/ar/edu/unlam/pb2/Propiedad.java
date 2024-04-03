package ar.edu.unlam.pb2;

public class Propiedad {
	
	private String calle;
	private Integer numero;
	private String ciudad;
	private Double precio;
	private Boolean estaDisponible;
	private TipoDeOperacion tipo;
	
		
	public Propiedad(String calle, Integer numero, String ciudad, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipo) {
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.precio = precio;
		this.estaDisponible = estaDisponible;
		this.tipo = tipo;
	}
	
	public String getCalle() {
		return calle;
	}
	
	public void setCalle(String calle) {
		this.calle = calle;
	}
	
	public Integer getNumero() {
		return numero;
	}
	
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public Double getPrecio() {
		return precio;
	}
	
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	
	public Boolean getEstaDisponible() {
		return estaDisponible;
	}
	
	public void setEstaDisponible(Boolean estaDisponible) {
		this.estaDisponible = estaDisponible;
	}
	
	public TipoDeOperacion getTipo() {
		return tipo;
	}
	
	public void setTipo(TipoDeOperacion tipo) {
		this.tipo = tipo;
	}
	
	@Override
	public String toString() {
		return "Calle: " + calle + " " + numero + ", " + ciudad + ", precio: " + precio + ", " 
	+ (estaDisponible == true ? "Disponible, " : "No disponible, ") + tipo;

	}
	
	
	
}
