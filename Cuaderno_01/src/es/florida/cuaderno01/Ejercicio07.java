// 7.  Resolver el ejercicio anterior empleando otra estructura de bucle.

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio07 {

	public static void main(String[] args) {

		int suma = 0;
		int contador = 0;

		// Con while

//		while (contador<5) {
//			
//			int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
//			suma = suma + numero;
//			contador++;
//		}

//--------------------------------------------------------------------------------
		// Con do - while

		do {

			int numero = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número"));
			suma = suma + numero;
			contador++;

		} while (contador < 5);

		System.out.println("La suma de los " + contador + " números introducidos es " + suma);

	}

}
