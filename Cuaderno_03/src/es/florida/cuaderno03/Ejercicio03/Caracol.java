/*3. Crea una clase denominada “Caracol” que implemente Runnable y que tenga dos atributos: 
velocidad (tipo double) y nombre (tipo String). La aplicación deberá simular una carrera de 
1 m entre 5 caracoles (con nombres y velocidades distintas), mostrando por pantalla el 
progreso (en porcentaje) de cada caracol hasta que recorra la distancia completa.*/

package es.florida.cuaderno03.Ejercicio03;

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
		double[] velocidad = {0.01, 0.011, 0.0099, 0.00999, 0.0105};
		
		for (int i = 1; i <= caracoles; i++) {
			caracol = new Caracol(("Caracol_" + i), velocidad[i - 1]);
			Thread hilo = new Thread(caracol);
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
			System.out.println(nombre + " --> " + String.format("%.0f", porcentaje) + "%");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		System.out.println("El " + nombre + " ha finalizado la carrera ");
	}
}

