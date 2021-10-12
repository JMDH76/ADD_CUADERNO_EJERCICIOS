package es.florida.cuaderno02;

public class Ejercicio01 {

	static String enunciado = "01. Realiza un programa en Java que dados dos números enteros, devuelva por pantalla la suma \r\n"
			+ "    de todos los números que hay entre ellos (incluyéndolos).\n";

	public static void main(String[] args) {

		//System.out.println(enunciado);

		Ejercicio01 sumador = new Ejercicio01(); 	// Creamos un objeto de clase (en ejemplo "Sumador")
		int n1 = Integer.parseInt(args[0]); 		// Asignamos valores al intervalo a sumar desde args[]
		int n2 = Integer.parseInt(args[1]);
		int resultado = sumador.sumar(n1, n2); 		// Invocamos la funcion "sumar()" pasandole los argumentos como valores
		System.out.println("Resultado: " + resultado);
	}

	/*
	 * Metodo sumar() 
	 * FUNCIONAMIENTO: suma mediante un bucle todos los valores desde el valor 
	 * más pequeño del intervalo al mayor. 	 
 	 * INPUT: enteros con los valoresdel intervalo. 
	 * OUTPUT: entero con el valor de la suma
	 */
	public int sumar(int n1, int n2) {
		int suma = 0;
		System.out.println("Sumando de " + n1 + " hasta " + n2 + "...");
		for (int i = Math.min(n1, n2); i <= Math.max(n1, n2); i++) {
			suma = suma + i;
		}
		return suma;
	}

}
