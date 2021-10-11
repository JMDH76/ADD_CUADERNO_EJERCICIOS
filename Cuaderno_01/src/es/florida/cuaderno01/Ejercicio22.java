/* 22. 	Modifica el programa anterior para que almacene en una estructura el nombre de un 
		número cualquiera de personas, introducidos por teclado de uno en uno. La condición de 
		finalización es introducir un 0 por teclado.*/

package es.florida.cuaderno01;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Ejercicio22 {

	public static void main(String[] args) {

		ArrayList<String> nombres = new ArrayList<String>();
		String nombre;

		do {
			nombre = JOptionPane.showInputDialog("Introduce un nombre");

			if (nombre.charAt(0) == '0') {
				break;
			} else {
				nombres.add(nombre);
			}

		} while (nombre.charAt(0) != '0');

		for (String name : nombres) {
			System.out.println(name);
		}
	}
}
