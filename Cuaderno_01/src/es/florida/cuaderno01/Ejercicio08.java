/*	8. 	Desarrolla un programa que lea por teclado un número del 1 al 12 e indique por pantalla a 
	qué mes del año en texto corresponde. Sugerencia: utilizar una estructura de programación 
	if … else.*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio08 {

	public static void main(String[] args) {

		int numero_mes;
		String mes = "";

		do {
			numero_mes = Integer.parseInt(JOptionPane.showInputDialog("Indica un número del 1 al 12"));

			if (numero_mes > 12 || numero_mes < 0) {

				System.out.println("Debes introducir un número entre 1 y 12");
			}

		} while (numero_mes > 12 || numero_mes < 0);

		if (numero_mes == 1) {
			mes = "Enero";
		} else if (numero_mes == 2) {
			mes = "Febrero";
		} else if (numero_mes == 3) {
			mes = "Marzo";
		} else if (numero_mes == 4) {
			mes = "Abril";
		} else if (numero_mes == 5) {
			mes = "Mayo";
		} else if (numero_mes == 6) {
			mes = "Junio";
		} else if (numero_mes == 7) {
			mes = "Julio";
		} else if (numero_mes == 8) {
			mes = "Agosto";
		} else if (numero_mes == 9) {
			mes = "Septiembre";
		} else if (numero_mes == 10) {
			mes = "Octubre";
		} else if (numero_mes == 11) {
			mes = "Noviembre";
		} else if (numero_mes == 12) {
			mes = "Diociembre";
		}

		// System.out.println("El mes " + numero_mes + " es " + mes); //Por consola
		JOptionPane.showMessageDialog(null, "El mes " + numero_mes + " es " + mes); // Por cuadro de dialogo

	}

}