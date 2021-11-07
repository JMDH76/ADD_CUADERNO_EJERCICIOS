/*3. Crea una clase denominada “Caracol” que implemente Runnable y que tenga dos atributos: 
velocidad (tipo double) y nombre (tipo String). La aplicación deberá simular una carrera de 
1 m entre 5 caracoles (con nombres y velocidades distintas), mostrando por pantalla el 
progreso (en porcentaje) de cada caracol hasta que recorra la distancia completa.*/

package es.florida.cuaderno03.Ejercicio03;

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
		
		for (int i = 1; i<=caracoles; i++) {
			caracol = new Caracol (("Caracol_" + i), generarAleatorio());
			Thread hilo = new Thread(caracol);
			hilo.start();
		}

	}

	
	public static double generarAleatorio() {
		double min = 0.2;
		double max = 0.4;
		double aleatorio = Math.random()*(min - max + 0.1) + max;
		System.out.println("Numero aleatorio: " + aleatorio);
		return aleatorio;
	}
	
	
	
	@Override
	public void run() {
		
		double distancia;
		long inicial = System.currentTimeMillis();
		boolean flag = true;
		double progreso;
		
		while (flag) {
			long intermedio = System.currentTimeMillis();
			double tiempo = (intermedio - inicial)/1000;
			distancia = velocidad * (tiempo);
			if (distancia <= 1) {
				progreso = distancia / 0.01; 	
			} else {
				progreso = 100;
				flag = false;
			}
			System.out.println(nombre + " --> " + String.format("%.0f", progreso) + "%");
		}
		long tfinal = System.currentTimeMillis();
		long tiempocarrera =  (tfinal - inicial) / 1000 ;
		System.out.println("El " + nombre + " ha finalizado la carrera con un tiempo de " + tiempocarrera + "seg");
	}

}
