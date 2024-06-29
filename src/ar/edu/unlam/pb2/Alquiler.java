package ar.edu.unlam.pb2;

public class Alquiler implements Operador{
	private Propiedad prop;
	private Inquilino inquilino;
	private String fechaInicio;
	private String fechaFin;

	public Alquiler(Propiedad prop, Inquilino inquilino, String fechaInicio, String fechaFin) {
		this.prop = prop;
		this.inquilino = inquilino;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Propiedad getProp() {
		return prop;
	}

	public void setProp(Propiedad prop) {
		this.prop = prop;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(String fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(String fechaFin) {
		this.fechaFin = fechaFin;
	}

	@Override
	public void operar() {
		inquilino.setPropiedad(prop);
	}
	
}
