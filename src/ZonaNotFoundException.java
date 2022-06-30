package entradas;

public class ZonaNotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public ZonaNotFoundException(){
		super();
	}
	
	public ZonaNotFoundException(String mesagge){
		super(mesagge);
		
	}
}
