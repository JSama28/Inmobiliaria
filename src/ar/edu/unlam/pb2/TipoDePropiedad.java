package ar.edu.unlam.pb2;

public enum TipoDePropiedad {
	CASA, DEPARTAMENTO, PH, TERRENO;
	
	public char getIdChar() {
		switch (this) {
		case CASA: return 'C';
		case DEPARTAMENTO: return 'D';
		case TERRENO: return 'T';
		case PH: return 'P';
		}
		return ' ';
	}
}
