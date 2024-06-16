package Exceptions;

public class UmbralMinimoNoAlcanzadoException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public UmbralMinimoNoAlcanzadoException() {
		
	}
	
	public UmbralMinimoNoAlcanzadoException(String mensaje) {
		super(mensaje);
	}
}
