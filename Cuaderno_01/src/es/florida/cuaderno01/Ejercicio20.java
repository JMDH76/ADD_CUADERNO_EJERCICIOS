/* 	20.	 Ampliar el programa anterior incluyendo tambi�n los caracteres de ASCII extendido.*/

package es.florida.cuaderno01;

public class Ejercicio20 {

	public static void main(String[] args) {
		for (int i = 0; i < 256; i++) {
			char equivalencia = (char) i;
			System.out.println("El valor ASCII extendido de " + i + " es " + equivalencia);
		}

	}

}
