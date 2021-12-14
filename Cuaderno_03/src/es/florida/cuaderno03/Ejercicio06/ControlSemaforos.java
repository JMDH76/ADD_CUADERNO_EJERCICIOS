/*6. Basándote en el problema del Productor-Consumidor (comunicación entre hilos), desarrolla 
un programa que tenga una clase “ControlSemaforos” con dos métodos que simulan dos 
semáforos distintos (“encenderSemaforo1” y “encenderSemaforo2”, que hace alternar los 
semáforos entre verde y rojo cada 3 segundos, no pudiendo estar los dos en el mismo estado 
a la vez) y un método “main” que crea un objeto “ControlSemaforos” y dos hilos, uno por 
cada semáforo. 
Puedes utilizar una variable de tipo int para controlar qué semáforo está en verde, de forma 
que cuando 1 esté en verde, el semáforo 2 espere en rojo. Cuando pasen 5 segundos, el 
semáforo 1 que está en verde cambiará a rojo y lo notificará al semáforo 2, que dejará de 
esperar y pasará a verde durante otros 5 segundos.*/

package es.florida.cuaderno03.Ejercicio06;

public class ControlSemaforos{

	boolean control = true;
	int tiempoVerde = 3000;

	public void encenderSemaforo1() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while(control != true) {
					wait();
				}
				System.out.println("El semáforo 1 está en verde  -->  Semáforo 2 está en rojo");
				control = false;
				notify();
				Thread.sleep(tiempoVerde);
			}
		}
	}

	public void encenderSemaforo2() throws InterruptedException {
		while (true) {
			synchronized (this) {
				while(control == true) {
					wait();
				}
				System.out.println("El semáforo 2 está en verde  -->  Semáforo 1 está en rojo");
				control = true;
				notify();
				Thread.sleep(tiempoVerde);
			}
		}
	}

	
	public static void main(String[] args) throws InterruptedException {

		ControlSemaforos cs = new ControlSemaforos();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					cs.encenderSemaforo1();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});

		
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					cs.encenderSemaforo2();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
	}
}
