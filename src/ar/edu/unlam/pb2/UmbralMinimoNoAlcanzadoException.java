package ar.edu.unlam.pb2;

public class UmbralMinimoNoAlcanzadoException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public UmbralMinimoNoAlcanzadoException() {
		
	}
	
	public UmbralMinimoNoAlcanzadoException(String mensaje) {
		super(mensaje);
	}
}
