//	3.	Realiza un programa que lea dos n�meros desde teclado y muestre la suma por pantalla.

package es.florida.cuaderno01;

import java.util.*;

public class Ejercicio03 {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		System.out.print("Introduce un n�mero: ");
		double numero1 = input.nextDouble(); 				// no se puede usar coma del teclado n�merico

		System.out.print("Introduce otro n�mero: ");
		double numero2 = input.nextDouble();

		input.close();

		System.out.println("La suma de los n�meros introducidos es " + (numero1 + numero2));

	}
}