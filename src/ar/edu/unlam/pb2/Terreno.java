package ar.edu.unlam.pb2;

public class Terreno {
	
	private String calle;
	private Integer numero;
	private String ciudad;
	private Double mtsCuadrados;
	private Double precio;
	private Boolean estaDisponible;
	private TipoDeOperacion tipo;
	private Propietario propietario;
	private String idTerreno;
	
	
	public Terreno(String calle, Integer numero, String ciudad, Double mtsCuadrados, Double precio,
			Boolean estaDisponible, TipoDeOperacion tipo, Propietario propietario, String idTerreno) {
		super();
		this.calle = calle;
		this.numero = numero;
		this.ciudad = ciudad;
		this.mtsCuadrados = mtsCuadrados;
		this.precio = precio;
		this.estaDisponible = estaDisponible;
		this.tipo = tipo;
		this.propietario = propietario;
		this.idTerreno = idTerreno;
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


	public Double getMtsCuadrados() {
		return mtsCuadrados;
	}


	public void setMtsCuadrados(Double mtsCuadrados) {
		this.mtsCuadrados = mtsCuadrados;
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


	public Propietario getPropietario() {
		return propietario;
	}


	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}


	public String getIdTerreno() {
		return idTerreno;
	}


	public void setIdTerreno(String idTerreno) {
		this.idTerreno = idTerreno;
	}

	
	@Override
	public String toString() {
		return "Id: " + idTerreno + ", Calle: " + calle + " " + numero + ", Ciudad: " + ciudad + "Mts cuadrados: " + mtsCuadrados +  ", Precio: " + precio + ", " 
	+ (estaDisponible == true ? "Disponible, " : "No disponible, ") + tipo + ", Propietario: " + propietario.getNombre() + propietario.getApellido();
	}
	
	
}
