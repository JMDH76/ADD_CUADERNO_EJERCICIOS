/*6. Bas�ndote en el problema del Productor-Consumidor (comunicaci�n entre hilos), desarrolla 
un programa que tenga una clase �ControlSemaforos� con dos m�todos que simulan dos 
sem�foros distintos (�encenderSemaforo1� y �encenderSemaforo2�, que hace alternar los 
sem�foros entre verde y rojo cada 3 segundos, no pudiendo estar los dos en el mismo estado 
a la vez) y un m�todo �main� que crea un objeto �ControlSemaforos� y dos hilos, uno por 
cada sem�foro. 
Puedes utilizar una variable de tipo int para controlar qu� sem�foro est� en verde, de forma 
que cuando 1 est� en verde, el sem�foro 2 espere en rojo. Cuando pasen 5 segundos, el 
sem�foro 1 que est� en verde cambiar� a rojo y lo notificar� al sem�foro 2, que dejar� de 
esperar y pasar� a verde durante otros 5 segundos.*/

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
				System.out.println("El sem�foro 1 est� en verde  -->  Sem�foro 2 est� en rojo");
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
				System.out.println("El sem�foro 2 est� en verde  -->  Sem�foro 1 est� en rojo");
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
