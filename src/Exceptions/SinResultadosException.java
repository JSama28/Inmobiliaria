package Exceptions;

public class SinResultadosException extends Exception {

	private static final long serialVersionUID = 1L;

	public SinResultadosException() {
		
	}
	
	public SinResultadosException(String mensaje) {
		super(mensaje);
	}
}
