/* 	17. Realiza un programa que controle los requisitos de una contraseña introducida por teclado 
		(mínimo 5 caracteres, 1 número y 1 letra mayúscula).*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio17 {

	public static void main(String[] args) {

		String contrasenya = "";
		boolean controldigitos;
		boolean controldelongitud;
		boolean controlmayusculas;
		
		do {
			controldigitos = true;
			controlmayusculas = true;
			controldelongitud = true;
			String mensaje = "";
			
			contrasenya = JOptionPane.showInputDialog("Introduce una contraseña");
			
			if (contrasenya.length() < 5) {
				controldelongitud = false;
				mensaje = "Contraseña incorrecta.\nLa contraseña debe tener 5 o más caracteres";

			} else if (contrasenya.equals(contrasenya.toLowerCase()) == true) {
				mensaje = "Contraseña incorrect.\nLa contraseña debe contener al menos una mayúscula";
				controlmayusculas = false;
			
			} else if (contrasenya.contains("1") == false && contrasenya.contains("2") == false
					&& contrasenya.contains("3") == false && contrasenya.contains("4") == false
					&& contrasenya.contains("5") == false && contrasenya.contains("6") == false
					&& contrasenya.contains("7") == false && contrasenya.contains("8") == false
					&& contrasenya.contains("9") == false && contrasenya.contains("0") == false) {
				mensaje = "Error.\nLa contraseña debe contener al menos un número";
				controldigitos = false;
			}

			if (mensaje != "") JOptionPane.showMessageDialog(null, mensaje);

		} while (controldelongitud == false || controlmayusculas == false || controldigitos == false );
		
		System.out.println("Contraseña correcta.\nLa contraseña introducida es " + contrasenya);
	}

}
