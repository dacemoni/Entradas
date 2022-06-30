package Clases;

import java.util.Scanner;

import Excepciones.EntradaAlreadyExistsException;
import Excepciones.EntradaNotFoundException;
import Excepciones.TipoNotFoundException;
import Excepciones.ZonaCompletaException;
import Excepciones.ZonaNotFoundException;

public interface GestorEntradas {

	public void ventaEntrada(Scanner teclado) throws EntradaAlreadyExistsException, ZonaNotFoundException, ZonaCompletaException, TipoNotFoundException;

	public void consultaEntrada(Scanner teclado) throws EntradaNotFoundException;

	public void informeZona(Scanner teclado) throws ZonaNotFoundException;
}
