/* 	14. Desarrolla un programa que lea el valor del radio de una circunferencia y devuelva por 
		pantalla el di�metro y el �rea con una precisi�n de 3 decimales.*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio14 {

	public static void main(String[] args) {

		Float radio = Float.parseFloat(JOptionPane.showInputDialog("Introduce el radio de la circunferencia en cm"));

		System.out.println("Par�metros de la circunferencia:\n--------------------------------");
		System.out.printf("%s %.3f %s", "Di�metro:\t", radio * 2, "cm\n");
		System.out.printf("%s %.3f %s", "Area:\t\t", (float) Math.PI * Math.pow(radio, 2), "cm2");

	}

}
