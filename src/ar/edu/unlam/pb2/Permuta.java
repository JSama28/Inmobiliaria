package ar.edu.unlam.pb2;

public class Permuta {

	private Propietario duenioA;
	private Propiedad propiedadDeA;
	private Propietario duenioB;
	private Propiedad propiedadDeB;
	
	
	public Permuta(Propietario duenioA, Propiedad propiedadDeA, Propietario duenioB, Propiedad propiedadDeB) {
		super();
		this.duenioA = duenioA;
		this.propiedadDeA = propiedadDeA;
		this.duenioB = duenioB;
		this.propiedadDeB = propiedadDeB;
	}


	public Propietario getDuenioA() {
		return duenioA;
	}


	public void setDuenioA(Propietario duenioA) {
		this.duenioA = duenioA;
	}


	public Propiedad getPropiedadDeA() {
		return propiedadDeA;
	}


	public void setPropiedadDeA(Propiedad propiedadDeA) {
		this.propiedadDeA = propiedadDeA;
	}


	public Propietario getDuenioB() {
		return duenioB;
	}


	public void setDuenioB(Propietario duenioB) {
		this.duenioB = duenioB;
	}


	public Propiedad getPropiedadDeB() {
		return propiedadDeB;
	}


	public void setPropiedadDeB(Propiedad propiedadDeB) {
		this.propiedadDeB = propiedadDeB;
	}
	
	
	
	
}
