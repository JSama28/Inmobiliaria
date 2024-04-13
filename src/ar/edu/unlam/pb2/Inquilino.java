package ar.edu.unlam.pb2;

public class Inquilino {

	private String nombre;
	private String apellido;
	private Integer dni;
	private String telefono;
	private Casa casa;
	private Departamento departamento;
	private Ph ph;
	
	
	public Inquilino(String nombre, String apellido, Integer dni, String telefono, Casa casa, Departamento departamento, Ph ph) {
		
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.telefono = telefono;
		this.casa = casa;
		this.departamento = departamento;
		this.ph = ph;
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


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	public Casa getCasa() {
		return casa;
	}


	public void setCasa(Casa casa) {
		this.casa = casa;
	}


	public Departamento getDepartamento() {
		return departamento;
	}


	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}


	public Ph getPh() {
		return ph;
	}


	public void setPh(Ph ph) {
		this.ph = ph;
	}
	
	
	
	
}
