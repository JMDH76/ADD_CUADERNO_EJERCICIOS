/* 5. 	Realiza un programa que lea dos números desde teclado en un bucle repetitivo. 
 		El bucle deberá finalizar cuando los números leídos sean iguales.*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio05 {

	public static void main(String[] args) {

		int numero1;
		int numero2;
		
		do {
		numero1 = Integer.parseInt(JOptionPane.showInputDialog("Introduce un número:"));
		numero2 = Integer.parseInt(JOptionPane.showInputDialog("Introduce otro número:"));
		
		if( numero1!=numero2) {
			System.out.println("Los números son diferentes. Vuelve a intentarlo");
		}
		
		} while (numero1 != numero2);
		
		System.out.println("Los números introducidos son iguales");
		
	}

}
