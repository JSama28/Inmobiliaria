package ar.edu.unlam.pb2;

public class Ph {

	private String calle;
	private Integer numero;
	private Integer numPh;
	private String ciudad;
	private Double precio;
	private Boolean estaDisponible;
	private TipoDeOperacion tipo;
	private Propietario propietario;
	private String idPh;
	
	
	public Ph(String calle, Integer numero, Integer numPh, String ciudad, Double precio, Boolean estaDisponible,
			TipoDeOperacion tipo, Propietario propietario, String idPh) {
		
		this.calle = calle;
		this.numero = numero;
		this.numPh = numPh;
		this.ciudad = ciudad;
		this.precio = precio;
		this.estaDisponible = estaDisponible;
		this.tipo = tipo;
		this.propietario = propietario;
		this.idPh = idPh;
	}

	public String getIdPh() {
		return idPh;
	}


	public void setIdPh(String idPh) {
		this.idPh = idPh;
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


	public Integer getNumPh() {
		return numPh;
	}


	public void setNumPh(Integer numPh) {
		this.numPh = numPh;
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


	public Propietario getPropietario() {
		return propietario;
	}


	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}
	
	
	@Override
	public String toString() {
		return "Calle: " + calle + " " + numero + ", NroPh: " + numPh + ", Ciudad: " + ciudad + ", Precio: " + precio + ", " 
	+ (estaDisponible == true ? "Disponible, " : "No disponible, ") + tipo + " Propietario: " + propietario;
	}
	
	
}