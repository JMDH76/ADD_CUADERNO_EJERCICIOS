/*	27. De la misma forma que en el ejercicio anterior, implementar en un m�todo adicional el 
		c�lculo de la letra del DNI (ejercicio 11) para que sea llamado desde �main�.*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio27 {

	static String caracteres = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	public static void main(String[] args) {
		
		JOptionPane.showMessageDialog(null, "27. De la misma forma que en el ejercicio anterior, implementar en\n "
				+ "un m�todo adicional el c�lculo de la letra del DNI (ejercicio 11)\n"
				+ "para que sea llamado desde 'main' ");

		String dni;
		
		do {
			dni = JOptionPane.showInputDialog("Inserte un n�mero de DNI");
			if (dni.length() != 8) {
				JOptionPane.showMessageDialog(null, "Error\nEl n�mero debe tener 8 cifras");
			}
		} while (dni.length() != 8);

		char letra = calculaLetra(dni);

		JOptionPane.showMessageDialog(null,
				"La letra correspondiente a su DNI es la " + letra + ".\nSu NIF es: " + dni + letra);
	}
	
	public static char calculaLetra (String dni) {
		
		int resto = Integer.parseInt(dni) % 23;
		char letra = caracteres.charAt(resto);
		return letra;
	}
}
