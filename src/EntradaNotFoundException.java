package entradas;

public class EntradaNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public EntradaNotFoundException(){
		super();
	}
	
	public EntradaNotFoundException(String mesagge){
		super(mesagge);
		
	}
}
