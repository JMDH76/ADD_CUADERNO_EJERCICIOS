/* 	18. Ampl�a el programa anterior haciendo que el usuario repita la contrase�a y comprobando 
		que lo ha hecho correctamente.*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio18 {

	public static void main(String[] args) {

		String contrasenya = "";

		boolean controldigitos;
		boolean controldelongitud;
		boolean controlmayusculas;
		boolean verificacion;

		do {
			controldigitos = true;
			controlmayusculas = true;
			controldelongitud = true;
			verificacion = true;
			String mensaje = "ok";

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

			if (mensaje != "ok")
				JOptionPane.showMessageDialog(null, mensaje);

			
			String contrasenyabis = JOptionPane.showInputDialog("Verifica tu contrase�a.\nIntroduce la contrase�a de nuevo");

			if (contrasenya.equals(contrasenyabis) == false) {
				JOptionPane.showMessageDialog(null, "Contrase�a incorrecta.\n Intentalo de nuevo");
				verificacion = false;
			}

		} while (controldelongitud == false || controlmayusculas == false || controldigitos == false || verificacion == false);
		
		JOptionPane.showMessageDialog(null, "Contrase�a correcta");
	}

}
