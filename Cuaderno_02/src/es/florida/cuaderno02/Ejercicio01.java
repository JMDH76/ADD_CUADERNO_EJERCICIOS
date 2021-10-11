package es.florida.cuaderno02;

public class Ejercicio01 {

	public static void main(String[] args) {

		System.out.println(
				"01. Realiza un programa en Java que dados dos números enteros, devuelva por pantalla la suma \r\n"
						+ "    de todos los números que hay entre ellos (incluyéndolos).\n");

		int n1 = 10;
		int n2 = 100;

		int suma = 0;
		for (int i = Math.min(n1, n2); i <= Math.max(n1, n2); i++) {
			suma = suma + i;
		}
		System.out.println("La suma de todos los numeros comprendidos entre " + n1 + " y " + n2 + " es igual a " + suma);
	}

}
