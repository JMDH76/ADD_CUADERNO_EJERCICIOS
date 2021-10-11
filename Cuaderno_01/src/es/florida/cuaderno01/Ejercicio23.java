/*	23. 	Amplía el programa anterior para que, una vez tenga almacenados los nombres en una 
			ariable, los muestre por pantalla de uno en uno de la siguiente forma: primera línea: “1. 
			Primer nombre”, segunda línea: “2. Segundo nombre”,… */

package es.florida.cuaderno01;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Ejercicio23 {

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

		int contador = 0;
		for (String name : nombres) {
			contador++;
			System.out.println(contador +". "+ name);
		}
	}

}
