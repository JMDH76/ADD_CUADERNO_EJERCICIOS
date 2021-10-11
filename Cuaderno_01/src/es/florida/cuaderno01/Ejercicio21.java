/* 	21. Crea un programa que almacene en una estructura el nombre de 5 personas que se irán 
		introduciendo por teclado de uno en uno.*/

package es.florida.cuaderno01;

import javax.swing.JOptionPane;

public class Ejercicio21 {

	public static void main(String[] args) {
		
		String[] nombres = new String[5];

		for (int i = 0; i < nombres.length; i++) {
			String nombre = JOptionPane.showInputDialog("Introduce un nombre");
			nombres[i]=nombre;
		}
		
		for(String nombre: nombres) {	
			System.out.println(nombre);
		}

	}

}
