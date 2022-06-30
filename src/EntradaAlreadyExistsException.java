package entradas;

public class EntradaAlreadyExistsException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EntradaAlreadyExistsException(){
		super();
	}
	
	public EntradaAlreadyExistsException(String mesagge){
		super(mesagge);
		
	}
}
