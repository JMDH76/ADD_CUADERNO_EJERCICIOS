/* 	13.	Programa que lea un valor de grados cent�grados desde teclado y lo muestre en grados 
		Fahrenheit con una precisi�n de 1 decimal.*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio13 {

	public static void main(String[] args) {

		double gradosCentigrados = Double.parseDouble(JOptionPane.showInputDialog("Introduce una temperatura en �C"));

		System.out.print(gradosCentigrados + "�C equivalen a ");
		System.out.printf("%1.2f", gradosCentigrados * 9 / 5 + 32);
		System.out.println("�F");
	}

}
