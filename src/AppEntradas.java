package entradas;

import java.util.InputMismatchException;
import java.util.Scanner;

public class AppEntradas{
	public static void main(String[] args){        
		menuInicio();
	}

	private static void menuInicio(){
		GestorEntradas entradas = new GestorEntradasImpl();

		int opcion = 0;

		try (Scanner teclado = new Scanner(System.in)){
			do{ 
				menu();

				try{    
					opcion = teclado.nextInt();                                 
				} 
				catch (InputMismatchException imEx){
					teclado.next();
					opcion = 0;
				}
				teclado.nextLine();
				switch (opcion){
				case 1:
					try {
						entradas.ventaEntrada(teclado);
					} 
					catch (EntradaAlreadyExistsException | TipoNotFoundException | ZonaCompletaException | ZonaNotFoundException e1) {
						System.out.println(e1.getMessage());
					}
					break;
				case 2:
					try {
						entradas.consultaEntrada(teclado);
					} 
					catch (EntradaNotFoundException e2) {
						System.out.println(e2.getMessage());
					}
					break;
				case 3:
					try {
						entradas.informeZona(teclado);
					} 
					catch (ZonaNotFoundException e) {
						System.out.println(e.getMessage());
					}
					break;
				case 4:
					System.out.println("Gracias.");
					break;

				default:
					System.out.println("No existe esta opcion.");
				}
			} while (opcion != 4);
		}
	}

	private static void menu(){
		System.out.println("");
		System.out.println("¿Qué quieres hacer?");
		System.out.println("1. Vender entrada");
		System.out.println("2. Consulta entrada");
		System.out.println("3. Informe zona");
		System.out.println("4. Terminar y salir");
		System.out.println("");
	}
}
