/*4. Crea una variación del programa anterior que asigne a todos los caracoles la misma 
velocidad, pero prioridades distintas a sus hilos correspondientes.*/

package es.florida.cuaderno03.Ejercicio04;

public class Caracol implements Runnable{
	
	String nombre;
	double velocidad;
	
	public Caracol(String nombre, double velocidad) {
		this.nombre = nombre;
		this.velocidad = velocidad;
	}


	public static void main(String[] args) {
		
		int caracoles = 5;
		Caracol caracol;
		
		int[] prioridad = { 2, 8, 6, 9, 1 };
		
		for (int i = 1; i <= caracoles; i++) {
			caracol = new Caracol(("Caracol_" + i), 0.2);
			Thread hilo = new Thread(caracol);
			hilo.setPriority(prioridad[i-1]);
			hilo.start();
		}
	}

	
	@Override
	public void run() {
		
		double distancia;
		long inicial = System.nanoTime();
		boolean flag = true;
		double progreso;
		
		while (flag) {
			long intermedio = System.nanoTime();
			double tiempo = (intermedio - inicial)/1000;
			
			//Añadimos par arelentizar el procesador
			for (int i = 0; i < 1e9; i++) {
				double resultadoTonto = Math.sqrt((double)(i));
				}

			distancia = velocidad * (tiempo);
			if (distancia <= 1) {
				progreso = distancia / 0.01; 	
			} else {
				progreso = 100;
				flag = false;
			}
			//System.out.println(nombre + " --> " + String.format("%.0f", progreso) + "%");
		}
		long tfinal = System.nanoTime();
		long tiempocarrera =  (tfinal - inicial) ;
		System.out.println("El " + nombre + " ha finalizado la carrera con un tiempo de " + tiempocarrera + "ns");
	}

}

