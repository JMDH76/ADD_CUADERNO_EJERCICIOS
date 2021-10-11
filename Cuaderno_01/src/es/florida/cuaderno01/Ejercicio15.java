/*	15.	Amplia el programa anterior para que devuelve el volumen de una esfera definida por el 
		mismo radio.*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio15 {

	public static void main(String[] args) {

		Float radio = Float.parseFloat(JOptionPane.showInputDialog("Introduce el radio de la esfera en cm"));

		System.out.println("Parámetros de la esfera:\n------------------------");
		System.out.printf("%s %1.3f %s", "Diámetro:\t", radio * 2, "cm\n");
		System.out.printf("%s %1.3f %s", "Area:\t\t", (float) Math.PI * Math.pow(radio, 2), "cm2\n");
		System.out.printf("%s %1.3f %s", "Volúmen:\t", (float) (4 * Math.PI * Math.pow(radio, 3)/3), "cm3");

	}
}
