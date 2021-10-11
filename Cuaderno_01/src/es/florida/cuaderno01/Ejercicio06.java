//	6. 	Realiza un programa que lea cinco números desde teclado y muestre la suma por pantalla. 
// 		Sugerencia: utilizar una estructura de bucle

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio06 {

	public static void main(String[] args) {

		int suma = 0;
		int contador = 0;

		for (int i = 0; i < 5; i++) {

			int numero = Integer.parseInt(JOptionPane.showInputDialog("Intoduce un número"));
			suma = suma + numero;
			contador++;
		}

		System.out.println("La suma de los " + contador + " números introducidos es " + suma);
	}

}
