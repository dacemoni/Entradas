package Clases;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import Excepciones.EntradaAlreadyExistsException;
import Excepciones.EntradaNotFoundException;
import Excepciones.TipoNotFoundException;
import Excepciones.ZonaCompletaException;
import Excepciones.ZonaNotFoundException;

public class GestorEntradasImpl implements GestorEntradas {
	private List<Entrada> entradasSinDuplicados;
	Teatro nuevoTeatro = new Teatro(0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0);
	private int precio = 0;
	private int id = 0;

	public GestorEntradasImpl() {
		entradasSinDuplicados = new ArrayList<>();
	}

	@Override
	public void ventaEntrada(Scanner teclado) throws EntradaAlreadyExistsException, ZonaNotFoundException, ZonaCompletaException, TipoNotFoundException {
		System.out.println("Introduce la zona de la entrada: (Principal/Palco/Central/Lateral)");
		String zona = teclado.next();
		if (!zona.equals("Principal") && !zona.equals("Palco") && !zona.equals("Central") && !zona.equals("Lateral")) {
			throw new ZonaNotFoundException(String.format("La zona %s no existe", zona));
		}

		System.out.println("Introduce el tipo de entrada: (normal/reducido/abonado) ");      
		String tipo = teclado.next();
		if (!tipo.equals("normal") && !tipo.equals("reducido") && !tipo.equals("abonado")) {
			throw new TipoNotFoundException(String.format("El tipo de entrada %s no existe", tipo));
		}

		System.out.println("Introduce el nombre del comprador: ");
		String nombreComprador = teclado.next();

		if (tipo.equals("normal") && zona.equals("Principal") && nuevoTeatro.nEntradasPrincipal < 200) {
			id++;
			precio = 25;
			nuevoTeatro.nEntradasPrincipalNormal++;
			nuevoTeatro.nEntradasPrincipal++;
		}
		else if (tipo.equals("normal") && zona.equals("Palco") && nuevoTeatro.nEntradasPalco < 40) {
			id++;
			precio = 70;
			nuevoTeatro.nEntradasPalcoNormal++;
			nuevoTeatro.nEntradasPalco++;
		}
		else if (tipo.equals("normal") && zona.equals("Central") && nuevoTeatro.nEntradasCentral < 400) {
			id++;
			precio = 20;
			nuevoTeatro.nEntradasPalcoNormal++;
			nuevoTeatro.nEntradasCentral++;
		}
		else if (tipo.equals("normal") && zona.equals("Lateral") && nuevoTeatro.nEntradasLateral < 100) {
			id++;
			precio = 15;
			nuevoTeatro.nEntradasLateralNormal++;
			nuevoTeatro.nEntradasLateral++;
		}
		else if (tipo.equals("reducido") && zona.equals("Principal") && nuevoTeatro.nEntradasPrincipal < 200) {
			id++;
			precio = 21;
			nuevoTeatro.nEntradasPrincipalReducido++;
			nuevoTeatro.nEntradasPrincipal++;
		}
		else if (tipo.equals("reducido") && zona.equals("Palco") && nuevoTeatro.nEntradasPalco < 40) {
			id++;
			precio = 60;
			nuevoTeatro.nEntradasPalcoReducido++;
			nuevoTeatro.nEntradasPalco++;
		}
		else if (tipo.equals("reducido") && zona.equals("Central") && nuevoTeatro.nEntradasCentral < 400) {
			id++;
			precio = 17;
			nuevoTeatro.nEntradasCentralReducido++;
			nuevoTeatro.nEntradasCentral++;
		}
		else if (tipo.equals("reducido") && zona.equals("Lateral") && nuevoTeatro.nEntradasLateral < 100) {
			id++;
			precio = 13;
			nuevoTeatro.nEntradasLateralReducido++;
			nuevoTeatro.nEntradasLateral++;
		}
		else if (tipo.equals("abonado") && zona.equals("Principal") && nuevoTeatro.nEntradasPrincipal < 200) {
			id++;
			precio = 20;
			nuevoTeatro.nEntradasPrincipalAbonado++;
			nuevoTeatro.nEntradasPrincipal++;
		}
		else if (tipo.equals("abonado") && zona.equals("Palco") && nuevoTeatro.nEntradasPalco < 40) {
			id++;
			precio = 40;
			nuevoTeatro.nEntradasPalcoAbonado++;
			nuevoTeatro.nEntradasPalco++;
		}
		else if (tipo.equals("abonado") && zona.equals("Central") && nuevoTeatro.nEntradasCentral < 400) {
			id++;
			precio = 14;
			nuevoTeatro.nEntradasCentralAbonado++;
			nuevoTeatro.nEntradasCentral++;
		}
		else if (tipo.equals("abonado") && zona.equals("Lateral") && nuevoTeatro.nEntradasLateral < 100) {
			id++;
			precio = 10;
			nuevoTeatro.nEntradasLateralAbonado++;
			nuevoTeatro.nEntradasLateral++;
		}
		else {
			throw new ZonaCompletaException(String.format("La zona %s esta completa", zona));
		}

		Entrada entrada = new Entrada(id, zona, tipo, nombreComprador);

		if (entradasSinDuplicados.stream().anyMatch(c -> c.equals(entrada))){
			throw new EntradaAlreadyExistsException(String.format("La entrada %d ya existe y esta vendida", id));
		}
		else{
			entradasSinDuplicados.add(entrada);
		}
		System.out.println(String.format("La entrada %d vale: %d €", entrada.getId(), precio));     
	}

	@Override
	public void consultaEntrada(Scanner teclado) throws EntradaNotFoundException {
		System.out.println("Las entradas almacenadas que se han vendido son:");
		Collections.sort(entradasSinDuplicados);

		for (Entrada entrada : entradasSinDuplicados){
			System.out.println(String.format("%d", entrada.getId()));
		}
		System.out.println("Introduce el identificador de la entrada: "); 
		System.out.println(findEntrada(teclado));
	}

	@Override
	public void informeZona(Scanner teclado) throws ZonaNotFoundException {
		int precio = 0;
		System.out.println("Introduce la zona de la entrada: (Principal/Palco/Central/Lateral)");
		String zona = teclado.next();

		if (zona.equals("Principal") || zona.equals("principal")) {
			precio = (nuevoTeatro.nEntradasPrincipalNormal*25) + (nuevoTeatro.nEntradasPrincipalAbonado*20) + (nuevoTeatro.nEntradasPrincipalReducido*21);
			System.out.println(String.format("Las entradas vendidas en la zona %s son %d, por valor de %d €, quedan %d entradas en esta zona", zona, nuevoTeatro.getnEntradasPrincipal(), precio, 200 - nuevoTeatro.getnEntradasPrincipal()));
		}
		else if (zona.equals("Palco") || zona.equals("palco")) {
			precio = (nuevoTeatro.nEntradasPalcoNormal*70) + (nuevoTeatro.nEntradasPalcoAbonado*40) + (nuevoTeatro.nEntradasPalcoReducido*60);
			System.out.println(String.format("Las entradas vendidas en la zona %s son %d, por valor de %d €, quedan %d entradas en esta zona", zona, nuevoTeatro.getnEntradasPalco(), precio, 40 - nuevoTeatro.getnEntradasPalco()));
		}
		else if (zona.equals("Central") || zona.equals("central")) {
			precio = (nuevoTeatro.nEntradasCentralNormal*20) + (nuevoTeatro.nEntradasCentralAbonado*14) + (nuevoTeatro.nEntradasCentralReducido*17);
			System.out.println(String.format("Las entradas vendidas en la zona %s son %d, por valor de %d €, quedan %d entradas en esta zona", zona, nuevoTeatro.getnEntradasCentral(), precio, 400 - nuevoTeatro.getnEntradasCentral()));
		}
		else if (zona.equals("Lateral") || zona.equals("lateral")) {
			precio = (nuevoTeatro.nEntradasLateralNormal*15) + (nuevoTeatro.nEntradasLateralAbonado*10) + (nuevoTeatro.nEntradasLateralReducido*13);
			System.out.println(String.format("Las entradas vendidas en la zona %s son %d, por valor de %d €, quedan %d entradas en esta zona", zona, nuevoTeatro.getnEntradasLateral(), precio, 100 - nuevoTeatro.getnEntradasLateral()));
		}
		else {
			throw new ZonaNotFoundException(String.format("La zona %s no existe", zona));
		}
	}


	/////////////////////////////////////////////	Metodos Privados	//////////////////////////////////////////////////////////////////////////

	private Entrada findEntrada(Scanner teclado) throws EntradaNotFoundException {
		Optional<Entrada> entradaFound = null;
		int id = teclado.nextInt();
		long count = entradasSinDuplicados.stream().filter(c -> c.getId() == (id)).count();

		if (count == 0){
			throw new EntradaNotFoundException(String.format("La entrada con identificador %d no existe", id));
		}
		entradaFound = entradasSinDuplicados.stream().filter(c -> c.getId() == (id)).findFirst();
		return entradaFound.get();

	}
}

