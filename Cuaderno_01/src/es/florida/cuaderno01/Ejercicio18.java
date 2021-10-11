/* 	18. Amplía el programa anterior haciendo que el usuario repita la contraseña y comprobando 
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

			if (mensaje != "ok")
				JOptionPane.showMessageDialog(null, mensaje);

			
			String contrasenyabis = JOptionPane.showInputDialog("Verifica tu contraseña.\nIntroduce la contraseña de nuevo");

			if (contrasenya.equals(contrasenyabis) == false) {
				JOptionPane.showMessageDialog(null, "Contraseña incorrecta.\n Intentalo de nuevo");
				verificacion = false;
			}

		} while (controldelongitud == false || controlmayusculas == false || controldigitos == false || verificacion == false);
		
		JOptionPane.showMessageDialog(null, "Contraseña correcta");
	}

}
