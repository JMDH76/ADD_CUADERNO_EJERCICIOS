/* 	17. Realiza un programa que controle los requisitos de una contrase�a introducida por teclado 
		(m�nimo 5 caracteres, 1 n�mero y 1 letra may�scula).*/

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
			
			contrasenya = JOptionPane.showInputDialog("Introduce una contrase�a");
			
			if (contrasenya.length() < 5) {
				controldelongitud = false;
				mensaje = "Contrase�a incorrecta.\nLa contrase�a debe tener 5 o m�s caracteres";

			} else if (contrasenya.equals(contrasenya.toLowerCase()) == true) {
				mensaje = "Contrase�a incorrect.\nLa contrase�a debe contener al menos una may�scula";
				controlmayusculas = false;
			
			} else if (contrasenya.contains("1") == false && contrasenya.contains("2") == false
					&& contrasenya.contains("3") == false && contrasenya.contains("4") == false
					&& contrasenya.contains("5") == false && contrasenya.contains("6") == false
					&& contrasenya.contains("7") == false && contrasenya.contains("8") == false
					&& contrasenya.contains("9") == false && contrasenya.contains("0") == false) {
				mensaje = "Error.\nLa contrase�a debe contener al menos un n�mero";
				controldigitos = false;
			}

			if (mensaje != "") JOptionPane.showMessageDialog(null, mensaje);

		} while (controldelongitud == false || controlmayusculas == false || controldigitos == false );
		
		System.out.println("Contrase�a correcta.\nLa contrase�a introducida es " + contrasenya);
	}

}
