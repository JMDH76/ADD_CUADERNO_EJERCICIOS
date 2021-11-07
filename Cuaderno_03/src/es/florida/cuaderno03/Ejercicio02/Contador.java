/*2. Implementa una clase denominada “Contador” que implemente Runnable con tres 
atributos: un atributo de tipo String denominado “nombreHilo”, otro atributo de tipo entero 
denominado “inicioContador” y otro de tipo entero denominado “limiteContador”, que 
indicará el fin de la cuenta. El programa principal deberá crear 5 hilos contadores con límites 
distintos y que se muestre por pantalla la cuenta de cada uno. */

package es.florida.cuaderno03.Ejercicio02;

public class Contador implements Runnable{
	
	String nombreHilo;
	int inicioContador;
	int limiteContador;
	
	public Contador ( String nombreHilo, int inicioContador, int limiteContador) {
		this.nombreHilo = nombreHilo;
		this.inicioContador = inicioContador;
		this.limiteContador = limiteContador;
	}
	
	
	public static void main(String[] args) {

		int hilos = 5;
		Contador contador;
		
		for (int i = 1; i <= hilos; i++) {
			contador = new Contador(("H" + i), 0, generarAleatorio());
			Thread hilo = new Thread(contador);
			hilo.start();
		}
	}
	
	
	public static int generarAleatorio() {
		int min = 1;
		int max = 100;
		int aleatorio = (int) Math.floor(Math.random() * (min - max + 1) + max);
		//System.out.println("Numero aleatorio: " + aleatorio);
		return aleatorio;
	}
	
	
	
	@Override
	public void run() {
		
		long inicio = System.currentTimeMillis();
		for (int i = inicioContador; i <= limiteContador; i++ ) {
			System.out.println("Contador "  + nombreHilo + ": " + i);			
		}
		long fin = System.currentTimeMillis();
		double tiempo = (fin - inicio);
		System.out.println("Contador "  + nombreHilo + " ha terminado y ha tardado " + tiempo + " ns en contar de 0 a " + limiteContador );
	}

}
