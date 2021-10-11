/*	23. 	Ampl�a el programa anterior para que, una vez tenga almacenados los nombres en una 
			ariable, los muestre por pantalla de uno en uno de la siguiente forma: primera l�nea: �1. 
			Primer nombre�, segunda l�nea: �2. Segundo nombre�,� */

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
