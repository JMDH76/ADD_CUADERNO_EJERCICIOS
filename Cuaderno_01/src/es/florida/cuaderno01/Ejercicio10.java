//	10. 	Realiza una modificaci�n del ejercicio anterior para que implemente un control de la entrada 
//			por teclado (admitir s�lo n�meros del 1 al 12).

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio10 {

	public static void main(String[] args) {

		int numero_mes;
		String mesString = "";

		do {

			numero_mes = Integer.parseInt(JOptionPane.showInputDialog("Introduce un n�mero entre 1 y 12"));

			if (numero_mes < 1 || numero_mes > 12) {
				JOptionPane.showMessageDialog(null, "�Error! \nIntroduce un n�mero entre 1 y 12");
			}

		} while (numero_mes < 1 || numero_mes > 12);

		switch (numero_mes) {

		case 1:
			mesString = "Enero";
			break;
		case 2:
			mesString = "Febrero";
			break;
		case 3:
			mesString = "Marzo";
			break;
		case 4:
			mesString = "Abril";
			break;
		case 5:
			mesString = "Mayo";
			break;
		case 6:
			mesString = "Junio";
			break;
		case 7:
			mesString = "Julio";
			break;
		case 8:
			mesString = "Agosto";
			break;
		case 9:
			mesString = "Septiembre";
			break;
		case 10:
			mesString = "Octubre";
			break;
		case 11:
			mesString = "Noviembre";
			break;
		case 12:
			mesString = "Diciembre";
			break;
		}

		JOptionPane.showMessageDialog(null, "El mes " + numero_mes + " es " + mesString);

	}

}
