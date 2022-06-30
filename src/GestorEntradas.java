package entradas;

import java.util.Scanner;

public interface GestorEntradas {

	public void ventaEntrada(Scanner teclado) throws EntradaAlreadyExistsException, ZonaNotFoundException, ZonaCompletaException, TipoNotFoundException;

	public void consultaEntrada(Scanner teclado) throws EntradaNotFoundException;

	public void informeZona(Scanner teclado) throws ZonaNotFoundException;
}
