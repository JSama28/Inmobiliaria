package ar.edu.unlam.pb2;

public class Propietario {
	private String nombre;
	private String apellido;
	private Integer dni;
	private String domicilio;
	private String telefono;
	private Casa casa[];
	private Departamento departamento[];
	private Ph ph[];
	private Terreno terreno[];
	private final Integer cantidadMaximaDePropiedades = 100;

	

	public Propietario(String nombre, String apellido, Integer dni, String domicilio, String telefono) {
	
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.domicilio = domicilio;
		this.telefono = telefono;
		this.casa = new Casa[cantidadMaximaDePropiedades];
		this.departamento = new Departamento[cantidadMaximaDePropiedades];
		this.ph = new Ph[cantidadMaximaDePropiedades];
		this.terreno = new Terreno[cantidadMaximaDePropiedades];
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Integer getDni() {
		return dni;
	}

	public void setDni(Integer dni) {
		this.dni = dni;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Casa[] getCasa() {
		return casa;
	}

	public void setCasa(Casa[] casa) {
		this.casa = casa;
	}

	public Departamento[] getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento[] departamento) {
		this.departamento = departamento;
	}

	public Ph[] getPh() {
		return ph;
	}

	public void setPh(Ph[] ph) {
		this.ph = ph;
	}

	public Terreno[] getTerreno() {
		return terreno;
	}

	public void setTerreno(Terreno[] terreno) {
		this.terreno = terreno;
	}
	
	
	
	
	
	
}
