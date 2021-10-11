//	3. 	Realiza un programa que lea dos números desde teclado y muestre la suma por pantalla.

package es.florida.cuaderno01;

import javax.swing.*;

public class Ejercicio03b {

	public static void main(String[] args) {

		String num1 = JOptionPane.showInputDialog("Introduce un número: ");
		String num2 = JOptionPane.showInputDialog("Inserta otro número: ");

		double numero1 = Double.parseDouble(num1);
		double numero2 = Double.parseDouble(num2);

		System.out.print("La suma de los números introducidos es ");
		System.out.printf("%1.2f", (numero1 + numero2)); 						// "printf" para dar formato a los números
	}
}
