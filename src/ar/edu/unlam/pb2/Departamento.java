package ar.edu.unlam.pb2;

public class Departamento {

	private String calle;
	private Integer numero;
	private Integer numDep;
	private String siglaDep;
	private String torre;
	private String ciudad;
	private Double precio;
	private Boolean estaDisponible;
	private TipoDeOperacion tipo;
	private Propietario propietario;
	private String idDep;
	
	
	public Departamento(String calle, Integer numero, Integer numDep, String siglaDep, String torre,
			String ciudad, Double precio, Boolean estaDisponible, TipoDeOperacion tipo, Propietario propietario, String idDep) {
		
		this.calle = calle;
		this.numero = numero;
		this.numDep = numDep;
		this.siglaDep = siglaDep;
		this.torre = torre;
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


	public Integer getNumDep() {
		return numDep;
	}


	public void setNumDep(Integer numDep) {
		this.numDep = numDep;
	}


	public String getSiglaDep() {
		return siglaDep;
	}


	public void setSiglaDep(String siglaDep) {
		this.siglaDep = siglaDep;
	}


	public String getTorre() {
		return torre;
	}


	public void setTorre(String torre) {
		this.torre = torre;
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
		return "Calle: " + calle + " " + numero + ", Departamento: " + numDep + siglaDep + ", Torre:" + torre + ", Ciudad: " + ciudad + ", Precio: " + precio + ", " 
	+ (estaDisponible == true ? "Disponible, " : "No disponible, ") + tipo + " Propietario: " + propietario;
	}
	
	
}
