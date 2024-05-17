package ar.edu.unlam.pb2;

import java.util.ArrayList;

public class Propietario extends Cliente{
	private ArrayList<Casa> casas;
	private ArrayList<Departamento> departamentos;
	private ArrayList<Ph> phs;
	private ArrayList<Terreno> terrenos;
	
	public Propietario(String nombre, String apellido, Integer dni, String email, String telefono) {
		super(nombre, apellido, dni, email, telefono);
	
		this.casas = new ArrayList<Casa>();
		this.departamentos = new ArrayList<Departamento>();
		this.phs = new ArrayList<Ph>();
		this.terrenos = new ArrayList<Terreno>();	
	}

	public ArrayList<Casa> getCasas() {
		return casas;
	}

	public void setCasas(ArrayList<Casa> casas) {
		this.casas = casas;
	}

	public ArrayList<Departamento> getDepartamentos() {
		return departamentos;
	}

	public void setDepartamentos(ArrayList<Departamento> departamentos) {
		this.departamentos = departamentos;
	}

	public ArrayList<Ph> getPhs() {
		return phs;
	}

	public void setPhs(ArrayList<Ph> phs) {
		this.phs = phs;
	}

	public ArrayList<Terreno> getTerrenos() {
		return terrenos;
	}

	public void setTerrenos(ArrayList<Terreno> terrenos) {
		this.terrenos = terrenos;
	}

}
