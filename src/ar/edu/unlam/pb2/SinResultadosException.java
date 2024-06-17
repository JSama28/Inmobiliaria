package ar.edu.unlam.pb2;

public class SinResultadosException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SinResultadosException() {
		
	}
	
	public SinResultadosException(String mensaje) {
		super(mensaje);
	}
}
