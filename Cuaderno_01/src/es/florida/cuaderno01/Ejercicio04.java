/* 4. 	Programa que lea dos números desde teclado y muestre el menor y el mayor en pantalla. 
		Si son iguales deberá mostrar un mensaje indicándolo.*/

package es.florida.cuaderno01;

//import java.util.Scanner;
import javax.swing.JOptionPane;

public class Ejercicio04 {

	public static void main(String[] args) {

		// Introduciendo por consola
		/*
		 Scanner input = new Scanner(System.in);
		 
		 System.out.println("Introduce un número"); float numero1 = input.nextFloat();
		 
		 System.out.println("Introduce otro número"); float numero2 =
		 input.nextFloat();
		  
		 input.close();
		 */

		// Introduciendo con ventana emergente, se puede poner la coma del teclado
		// numérico.

		float numero1 = Float.parseFloat(JOptionPane.showInputDialog("Introduce un número"));
		float numero2 = Float.parseFloat(JOptionPane.showInputDialog("Introduce otro número"));

		
		// Condiciones
		if (numero1 > numero2) {
			System.out.println("El número mayor es: " + numero1);
			System.out.println("El número menor es: " + numero2);
		} else if (numero2 > numero1) {
			System.out.println("El número mayor es: " + numero2);
			System.out.println("El número menor es: " + numero1);
		} else {
			System.out.println("Los dos números son iguales");
		}

	}

}
