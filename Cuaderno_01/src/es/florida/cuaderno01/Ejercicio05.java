/* 5. 	Realiza un programa que lea dos n�meros desde teclado en un bucle repetitivo. 
 		El bucle deber� finalizar cuando los n�meros le�dos sean iguales.*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio05 {

	public static void main(String[] args) {

		int numero1;
		int numero2;
		
		do {
		numero1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce un n�mero:"));
		numero2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce otro n�mero:"));
		
		if( numero1!=numero2) {
			System.out.println("Los n�meros son diferentes. Vuelve a intentarlo");
		}
		
		} while (numero1 != numero2);
		
		System.out.println("Los n�meros introducidos son iguales");
		
	}

}
