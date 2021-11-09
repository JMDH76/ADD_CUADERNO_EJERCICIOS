/*4. Crea una variación del programa anterior que asigne a todos los caracoles la misma 
velocidad, pero prioridades distintas a sus hilos correspondientes.*/

package es.florida.cuaderno03.Ejercicio04;


public class Caracol implements Runnable{
	
	double distancia = 1;
	String nombre;
	double velocidad;
	
	public Caracol(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	}

	
	public static void main(String[] args) {

		int caracoles = 5;
		Caracol caracol;
		int[] prioridad = { 1, 2, 3, 4, 10 };

		for (int i = 1; i <= caracoles; i++) {
			caracol = new Caracol(("Caracol_" + i), 0.01);
			Thread hilo = new Thread(caracol);
			hilo.setPriority(prioridad[i - 1]);
			hilo.start();
		}
	}

	
	@Override
	public void run() {

		double avance = 0;
		double porcentaje = 0;

		while (avance < distancia) {
			avance += velocidad * 1;
			porcentaje = 100 * avance / distancia;
			//System.out.println(nombre + " --> " + String.format("%.0f", porcentaje) + "%");
		}
		System.out.println("El " + nombre + " ha finalizado la carrera ");
	}
}
