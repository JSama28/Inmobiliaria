package ar.edu.unlam.pb2;

public class Permuta implements Operador{
	private Propiedad propA;
	private Propiedad propB;
	private Propietario duenioA;
	private Propietario duenioB;
	
	public Permuta(Propietario duenioA, Propiedad propA, Propietario duenioB, Propiedad propB) {
		this.propA = propA;
		this.propB = propB;
		this.duenioA = duenioA;
		this.duenioB = duenioB;
	}

	public Propiedad getPropA() {
		return propA;
	}

	public void setPropA(Propiedad propA) {
		this.propA = propA;
	}

	public Propiedad getPropB() {
		return propB;
	}

	public void setPropB(Propiedad propB) {
		this.propB = propB;
	}

	public Propietario getDuenioA() {
		return duenioA;
	}

	public void setDuenioA(Propietario duenioA) {
		this.duenioA = duenioA;
	}

	public Propietario getDuenioB() {
		return duenioB;
	}

	public void setDuenioB(Propietario duenioB) {
		this.duenioB = duenioB;
	}

	@Override
	public void operar() {
		duenioA.agregarPropiedad(propB);
		duenioB.agregarPropiedad(propA);
		duenioA.borrarPropiedad(propA);
		duenioB.borrarPropiedad(propB);		
	}
	
	
}
