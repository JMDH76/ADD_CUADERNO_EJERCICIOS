//	11.	Implementa un programa que dado un DNI (sin letra) por teclado devuelva el DNI con la 
//		letra correcta.

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio11 {

	public static void main(String[] args) {

		String dni;
		String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";

		do {

			dni = JOptionPane.showInputDialog("Inserte un número de DNI");
			if (dni.length() != 8) {
				JOptionPane.showMessageDialog(null, "Error\nEl número debe tener 8 cifras");
			}

		} while (dni.length() != 8);

		int resto = Integer.parseInt(dni) % 23;
		char letra = caracteres.charAt(resto);

		JOptionPane.showMessageDialog(null,
				"La letra correspondiente a su DNI es la " + letra + ".\nSu NIF es: " + dni + letra);
	}

}
