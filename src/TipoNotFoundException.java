package entradas;

public class TipoNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public TipoNotFoundException(){
		super();
	}
	
	public TipoNotFoundException(String mesagge){
		super(mesagge);
		
	}
}
