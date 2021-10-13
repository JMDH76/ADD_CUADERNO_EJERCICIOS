package es.florida.cuaderno02;

public class Sumador_EJ04 {
	

		public static void main(String[] args) {

			Sumador_EJ04 sumador = new Sumador_EJ04();	// Creamos un objeto de clase (en ejemplo "Sumador")
			int n1 = Integer.parseInt(args[0]); 		// Asignamos valores al intervalo a sumar desde args[]
			int n2 = Integer.parseInt(args[1]);
			int resultado = sumador.sumar(n1, n2); 		// Invocamos y pasamos a String para copiar en fichero
			System.out.println(resultado);
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
			for (int i = Math.min(n1, n2); i <= Math.max(n1, n2); i++) {
				suma = suma + i;
			}
			return suma;
		}
		
	}
