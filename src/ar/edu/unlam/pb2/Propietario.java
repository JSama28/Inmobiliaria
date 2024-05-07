package ar.edu.unlam.pb2;

public class Propietario extends Cliente{
	private Casa casa[];
	private Departamento departamento[];
	private Ph ph[];
	private Terreno terreno[];
	private final Integer cantidadMaximaDePropiedades = 100;

	public Propietario(String nombre, String apellido, Integer dni, String email, String telefono) {
		super(nombre, apellido, dni, email, telefono);
	
		this.casa = new Casa[cantidadMaximaDePropiedades];
		this.departamento = new Departamento[cantidadMaximaDePropiedades];
		this.ph = new Ph[cantidadMaximaDePropiedades];
		this.terreno = new Terreno[cantidadMaximaDePropiedades];	
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
