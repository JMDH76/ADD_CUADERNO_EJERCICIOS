/* 19. Realizar un programa que muestre por pantalla los caracteres ASCII (código y carácter)*/

package es.florida.cuaderno01;

public class Ejercicio19 {

	public static void main(String[] args) {

		for (int i = 0; i < 128; i++) {
			char equivalencia = (char) i;
			System.out.println("El valor ASCII original de " + i + " es " + equivalencia);
		}
		
	}

}
