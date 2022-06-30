package Excepciones;

public class ZonaCompletaException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ZonaCompletaException(){
		super();
	}
	
	public ZonaCompletaException(String mesagge){
		super(mesagge);
		
	}
}
