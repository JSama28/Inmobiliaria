package ar.edu.unlam.pb2;

import java.util.Date;

public class Alquiler {

	private Casa casa;
	private Departamento departamento;
	private Ph ph;
	private Propietario propietario;
	private Inquilino inquilino;
	private Date fechaInicio;
	private Date fechaFin;
	
	
	public Alquiler(Casa casa, Departamento departamento, Ph ph, Propietario propietario, Inquilino inquilino,
			Date fechaInicio, Date fechaFin) {
	
		this.casa = casa;
		this.departamento = departamento;
		this.ph = ph;
		this.propietario = propietario;
		this.inquilino = inquilino;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
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


	public Propietario getPropietario() {
		return propietario;
	}


	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}


	public Inquilino getInquilino() {
		return inquilino;
	}


	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}


	public Date getFechaInicio() {
		return fechaInicio;
	}


	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}


	public Date getFechaFin() {
		return fechaFin;
	}


	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
	
	
}
