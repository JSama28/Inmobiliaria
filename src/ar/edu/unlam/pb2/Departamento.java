package ar.edu.unlam.pb2;

public class Departamento {

	private String calle;
	private Integer numero;
	private String numDep;
	private String ciudad;
	private Double precio;
	private Boolean estaDisponible;
	private TipoDeOperacion tipo;
	private Propietario propietario;
	private String idDep;
	
	
	public Departamento(String calle, Integer numero, String numDep, String ciudad, Double precio, Boolean estaDisponible, 
			TipoDeOperacion tipo, Propietario propietario, String idDep) {
		
		this.calle = calle;
		this.numero = numero;
		this.numDep = numDep;
		this.ciudad = ciudad;
		this.precio = precio;
		this.estaDisponible = estaDisponible;
		this.tipo = tipo;
		this.propietario = propietario;
		this.idDep = idDep;
	}

	public String getIdDep() {
		return idDep;
	}
	
	public void setIdDep(String idDep) {
		this.idDep = idDep;
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


	public String getNumDep() {
		return numDep;
	}


	public void setNumDep(String numDep) {
		this.numDep = numDep;
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
		return "Id: " + idDep + ", Calle: " + calle + " " + numero + ", Departamento: " + numDep + ", Ciudad: " + ciudad + ", Precio: " + precio + ", " 
	+ (estaDisponible == true ? "Disponible, " : "No disponible, ") + tipo + ", Propietario: " + propietario.getNombre() + " "  + propietario.getApellido();
	}
	
	
}
