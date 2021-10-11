// 	2. 	Programa Java que lea un nombre desde teclado y muestre por pantalla un mensaje tipo “Hola xxxxx”.

package es.florida.cuaderno01;

import java.util.Scanner;

public class Ejercicio02 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in); 			// para introducir por teclado
		System.out.print("Introduce un nombre: "); 			// mensaje por pantalla
		String nombre = input.nextLine(); 					// asigna input por teclado a la variable

		System.out.println("¡Hola " + nombre + "!"); 		// muestra por pantalla el mensaje

		input.close(); 										// cerramos la introducción por teclado
	}
}