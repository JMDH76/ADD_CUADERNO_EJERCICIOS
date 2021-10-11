/* 	16.	Escribe un programa que dada la fecha de nacimiento de una persona devuelva su número 
		de la suerte (utiliza el algoritmo de cálculo que prefieras)*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio16 {

	public static void main(String[] args) {

		String fechaNacimiento = "";

		do {

			fechaNacimiento = JOptionPane.showInputDialog("Indica tu fecha de nacimiento (dd/mm/aaaa)");

			if (fechaNacimiento.length() < 10 || fechaNacimiento.length() > 10) {
				JOptionPane.showMessageDialog(null, "Introduce la fecha con el formato correcto (dd/mm/aaaa)");
			}

		} while (fechaNacimiento.length() < 10 || fechaNacimiento.length() > 10);

		int sumadia = Integer.parseInt(fechaNacimiento.substring(0, 1))
				+ Integer.parseInt(fechaNacimiento.substring(1, 2));
		int sumames = Integer.parseInt(fechaNacimiento.substring(3, 4))
				+ Integer.parseInt(fechaNacimiento.substring(4, 5));
		int sumaanyo = Integer.parseInt(fechaNacimiento.substring(6, 7))
				+ Integer.parseInt(fechaNacimiento.substring(7, 8)) + Integer.parseInt(fechaNacimiento.substring(8, 9))
				+ Integer.parseInt(fechaNacimiento.substring(9, 10));
		int sumatotal = sumadia + sumames + sumaanyo;

		int numerosuerte = (sumatotal / 10) + (sumatotal % 10);

		System.out.println("Tu número de la suerte es el " + numerosuerte);
	}

}
